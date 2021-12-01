package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        PessoaEntity pessoa = pessoaRepository.getById(idPessoa);

        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        contatoEntity.setPessoaEntity(pessoa);
        ContatoEntity criado = contatoRepository.save(contatoEntity);

        ContatoDTO contatoDTO = objectMapper.convertValue(criado, ContatoDTO.class);

        return contatoDTO;
    }

    public List<ContatoDTO> list() {
        return contatoRepository.findAll().stream()
                .map(contato -> {
                    ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
                    return contatoDTO;
                })
                .collect(Collectors.toList());
    }

//    public List<ContatoDTO> listByIdPessoa(Integer id) throws RegraDeNegocioException {
//        pessoaService.getById(id);
//        return contatoRepository.findAll().stream()
//                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
//                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
//                .collect(Collectors.toList());
//    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        findById(id);
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        contatoEntity.setIdContato(id);
        ContatoEntity atualizado = contatoRepository.save(contatoEntity);

        ContatoDTO contatoDTO = objectMapper.convertValue(atualizado, ContatoDTO.class);

        return contatoDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoEntity = findById(id);
        contatoRepository.delete(contatoEntity);
    }

    private ContatoEntity findById(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoEntity = contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não localizado!"));

        return contatoEntity;
    }

    public ContatoDTO getById(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoEntity = findById(id);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);

        return contatoDTO;
    }

}
