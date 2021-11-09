package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

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
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class)                )
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

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAll().stream()
                .filter(pessoa -> StringUtils.containsIgnoreCase(pessoa.getNome(), nome))
                .map(pessoa -> {
                    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                    return pessoaDTO;
                })
                .collect(Collectors.toList());
    }

}
