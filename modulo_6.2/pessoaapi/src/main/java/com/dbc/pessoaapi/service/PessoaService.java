package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        PessoaEntity pessoaCriada = pessoaRepository.save(pessoaEntity);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

        //emailService.envioComTemplateAoCriar(pessoaDTO);

        return pessoaDTO;
    }

    @Scheduled(cron = "0 0 20 23 12 *")
    public List<PessoaDTO> list() throws MessagingException, TemplateException, IOException {
        List<PessoaDTO> pessoas = pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
        ;

        for (PessoaDTO pessoa : pessoas) {
            emailService.schedulerTodasPessoas(pessoa);
        }

        return pessoas;
    }

    private PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não localizada!"));
        return pessoaEntity;
    }

    public PessoaDTO getById(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = findById(id);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);

        return pessoaDTO;
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaCreateDTO) throws Exception {
        findById(id);
        PessoaEntity entity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        entity.setIdPessoa(id);
        PessoaEntity pessoaEntity = pessoaRepository.save(entity);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);

        //emailService.envioComTemplateAoAtualizar(pessoaDTO);

        return pessoaDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = findById(id);

        pessoaRepository.delete(pessoaEntity);

        //emailService.envioComTemplateAoDeletar(pessoaDTO);
    }


    public List<PessoaComContatoDTO> listComContato(Integer id) throws RegraDeNegocioException {
        List<PessoaComContatoDTO> pessoaContato = new ArrayList<>();

        if (id == null) {
            return pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaComContatoDTO pessoaComContatoDTO = objectMapper.convertValue(pessoa, PessoaComContatoDTO.class);
                        pessoaComContatoDTO.setContatos(pessoa.getContatos().stream()
                                .map(contato -> {
                                    ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
                                    contatoDTO.setIdPessoa(pessoa.getIdPessoa());
                                    return contatoDTO;
                                })
                                .collect(Collectors.toList()));
                        return pessoaComContatoDTO;
                    })
                    .collect(Collectors.toList());
        }

        PessoaEntity pessoa = findById(id);
        PessoaComContatoDTO pessoaComContatoDTO = objectMapper.convertValue(pessoa, PessoaComContatoDTO.class);

        pessoaComContatoDTO.setContatos(pessoa.getContatos().stream()
                .map(contato -> {
                    ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
                    contatoDTO.setIdPessoa(pessoa.getIdPessoa());
                    return contatoDTO;
                })
                .collect(Collectors.toList()));

        pessoaContato.add(pessoaComContatoDTO);

        return pessoaContato;
    }

    public List<PessoaComEnderecoDTO> listComEndereco(Integer id) throws RegraDeNegocioException {
        List<PessoaComEnderecoDTO> pessoaEndereco = new ArrayList<>();

        if (id == null) {
            return pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaComEnderecoDTO pessoaComEnderecoDTO = objectMapper.convertValue(pessoa, PessoaComEnderecoDTO.class);
                        pessoaComEnderecoDTO.setEnderecos(pessoa.getEnderecos().stream()
                                .map(endereco -> {
                                    EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
                                    return enderecoDTO;
                                })
                                .collect(Collectors.toList()));
                        return pessoaComEnderecoDTO;
                    })
                    .collect(Collectors.toList());
        }

        PessoaEntity pessoa = findById(id);
        PessoaComEnderecoDTO pessoaComEnderecoDTO = objectMapper.convertValue(pessoa, PessoaComEnderecoDTO.class);

        pessoaComEnderecoDTO.setEnderecos(pessoa.getEnderecos().stream()
                .map(endereco -> {
                    EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
                    return enderecoDTO;
                })
                .collect(Collectors.toList()));

        pessoaEndereco.add(pessoaComEnderecoDTO);

        return pessoaEndereco;
    }

    public List<PessoaComContatoEnderecoDTO> listComContatoEEndereco() {
        return pessoaRepository.findAll().stream()
                .map(pessoa -> {
                    PessoaComContatoEnderecoDTO pessoaComContatoEnderecoDTO = objectMapper.convertValue(pessoa, PessoaComContatoEnderecoDTO.class);
                    pessoaComContatoEnderecoDTO.setContatos(pessoa.getContatos().stream()
                            .map(contato -> {
                                ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
                                contatoDTO.setIdPessoa(pessoa.getIdPessoa());
                                return contatoDTO;
                            })
                            .collect(Collectors.toList()));

                    pessoaComContatoEnderecoDTO.setEnderecos(pessoa.getEnderecos().stream()
                            .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                            .collect(Collectors.toList()));
                    return pessoaComContatoEnderecoDTO;

                })
                .collect(Collectors.toList());
    }

    @Scheduled(cron = "0 0 8,20 * * *")
    public List<PessoaDTO> findByPessoaQueNaoPossueEnderecoComQueryNativa() throws MessagingException, TemplateException, IOException {
        List<PessoaDTO> pessoas = pessoaRepository.findByPessoaQueNaoPossueEnderecoComQueryNativa().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
        ;

        for (PessoaDTO pessoa : pessoas) {
            emailService.scheduler(pessoa);
        }

        return pessoas;
    }


    @Scheduled(cron = "0 0 0 * * *")
    public void findByAniversario() throws MessagingException, TemplateException, IOException {
        List<PessoaDTO> pessoas = pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
        ;

        for (PessoaDTO pessoa : pessoas) {
            if (pessoa.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM"))
                    .equals(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM")))) {
                emailService.schedulerAniversario(pessoa);
            }
        }
    }

}
