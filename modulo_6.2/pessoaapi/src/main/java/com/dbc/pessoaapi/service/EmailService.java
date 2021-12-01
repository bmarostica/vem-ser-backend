package com.dbc.pessoaapi.service;

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
}
