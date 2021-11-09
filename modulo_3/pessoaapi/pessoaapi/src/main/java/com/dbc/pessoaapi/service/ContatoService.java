package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
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
        pessoaRepository.buscarPorId(idPessoa);
        contatoCreateDTO.setIdPessoa(idPessoa);

        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        ContatoEntity criado = contatoRepository.create(contatoEntity);

        ContatoDTO contatoDTO = objectMapper.convertValue(criado, ContatoDTO.class);

        return contatoDTO;
    }

    public List<ContatoDTO> list(){
        return contatoRepository.list().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> listByIdPessoa(Integer id) throws RegraDeNegocioException {
        pessoaRepository.buscarPorId(id);
        return contatoRepository.listByIdPessoa(id).stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException{
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        ContatoEntity atualizado = contatoRepository.update(id, contatoEntity);

        ContatoDTO contatoDTO = objectMapper.convertValue(atualizado, ContatoDTO.class);

        return contatoDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException{
        contatoRepository.delete(id);
    }

}
