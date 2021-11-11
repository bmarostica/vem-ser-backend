package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

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

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
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

    public List<PessoaComContatoEnderecoDTO> listComContatoEEndereco(){
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


}
