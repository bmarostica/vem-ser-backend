package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.EmailDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;
    private final Configuration configuration;

    @Value("${spring.mail.username}")
    private String remetente;

    public void envioComTemplateAoCriar(PessoaDTO pessoaDTO) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(remetente);
        helper.setTo("bianca.marostica@dbccompany.com.br");
        helper.setSubject("Cadastro realizado");

        Template template = configuration.getTemplate("email-exercicio1-template.ftl");
        Map<String, Object> dados = new HashMap<>();

        dados.put("nome", pessoaDTO.getNome());
        dados.put("id", pessoaDTO.getIdPessoa());
        dados.put("email", remetente);

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        helper.setText(html, true);

        emailSender.send(mimeMessage);
    }

    public void envioComTemplateAoAtualizar(PessoaDTO pessoaDTO) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(remetente);
        helper.setTo(pessoaDTO.getEmail());
        helper.setSubject("Alteração realizada");

        Template template = configuration.getTemplate("email-exercicio2-template.ftl");
        Map<String, Object> dados = new HashMap<>();

        dados.put("nome", pessoaDTO.getNome());
        dados.put("email", remetente);

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        helper.setText(html, true);

        emailSender.send(mimeMessage);
    }

    public void envioComTemplateAoDeletar(PessoaDTO pessoaDTO) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(remetente);
        helper.setTo(pessoaDTO.getEmail());
        helper.setSubject("Conta excluida");

        Template template = configuration.getTemplate("email-exercicio3-template.ftl");
        Map<String, Object> dados = new HashMap<>();

        dados.put("nome", pessoaDTO.getNome());
        dados.put("email", remetente);

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        helper.setText(html, true);

        emailSender.send(mimeMessage);
    }

    public void scheduler(PessoaDTO pessoaDTO) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(remetente);
        helper.setTo(pessoaDTO.getEmail());
        helper.setSubject("Atualizar endereço");

        Template template = configuration.getTemplate("scheduler.ftl");
        Map<String, Object> dados = new HashMap<>();

        dados.put("pessoa", pessoaDTO.getNome());

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        helper.setText(html, true);

        emailSender.send(mimeMessage);
    }

    public void schedulerTodasPessoas(PessoaDTO pessoaDTO) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(remetente);
        helper.setTo(pessoaDTO.getEmail());
        helper.setSubject("Pro moção e Pra mocinha");

        Template template = configuration.getTemplate("schedulerPessoas.ftl");
        Map<String, Object> dados = new HashMap<>();

        dados.put("pessoa", pessoaDTO.getNome());

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        helper.setText(html, true);

        emailSender.send(mimeMessage);
    }

    public void schedulerAniversario(PessoaDTO pessoaDTO) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(remetente);
        helper.setTo(pessoaDTO.getEmail());
        helper.setSubject("Parabéns");

        Template template = configuration.getTemplate("schedulerAniversario.ftl");
        Map<String, Object> dados = new HashMap<>();

        dados.put("nome", pessoaDTO.getNome());
        dados.put("data", pessoaDTO.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM")));
        dados.put("idade", LocalDate.now().getYear() - pessoaDTO.getDataNascimento().getYear());

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        helper.setText(html, true);

        emailSender.send(mimeMessage);
    }

    public EmailDTO enviarEmailComSchedule(PessoaEntity pessoaEntity) {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setDestinatario(pessoaEntity.getEmail());
        emailDTO.setAssunto("Atualize seu endereco");
        emailDTO.setTexto("Olá " + pessoaEntity.getNome() +
                " \nEstamos muito felizes que você está em nosso sistema.\n" +
                " Para que possamos enviá-lo um brinde exclusivo, adicione ou atualize o seu endereço no cadastro.\n" +
                " Muito obrigado,\n" +
                " Sistema de Pessoas.");

        return emailDTO;
    }

    public EmailDTO enviarEmailComSchedulePessoas(PessoaEntity pessoaEntity) {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setDestinatario(pessoaEntity.getEmail());
        emailDTO.setAssunto("Promoção e Pramocinha");
        emailDTO.setTexto("Olá " + pessoaEntity.getNome() +
                " \nSelecionamos algumas das nossas super promoções de natal na nossa plataforma especialmente pra você:\n" +
                " Na compra de 1 CD do Chitãozinho e Xororó, ganhe 1 do Milionário e José Rico\n" +
                " Na locação de um filme em VHS, a outra  locação é grátis\n" +
                " Fita super Nintendo 50% de desconto\n" +
                " Muito obrigado,\n" +
                " Sistema de Pessoas.");

        return emailDTO;
    }

    public EmailDTO enviarEmailComScheduleAniversario(PessoaEntity pessoaEntity) {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setDestinatario(pessoaEntity.getEmail());
        emailDTO.setAssunto("Parabéns!!!");
        emailDTO.setTexto("Olá " + pessoaEntity.getNome() +
                "Essa data " + pessoaEntity.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM")) +" também é especial para nós do Vem Ser.\n" +
                "Estamos comemorando juntos com você. \\o/ " +
                "Desejamos um feliz aniversário, que sejam "+ (LocalDate.now().getYear() - pessoaEntity.getDataNascimento().getYear()) +" anos de muito" +
                "sucesso, alegria, felicidade e muitas realizações." +
                "Forte Abraço!" +
                "Vem Ser 2021/2.");

        return emailDTO;
    }

}
