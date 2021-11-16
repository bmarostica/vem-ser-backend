package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    //private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        //pessoaRepository.findById(idPessoa);
        //enderecoCreateDTO.setIdPessoa(idPessoa);

        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity criar = enderecoRepository.save(enderecoEntity);

        return objectMapper.convertValue(criar, EnderecoDTO.class);
    }

    private EnderecoEntity findById(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não localizado!"));

        return enderecoEntity;
    }

    public List<EnderecoDTO> list(){
        return enderecoRepository.findAll().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO getByIdEndereco(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = findById(id);

        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }

//    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
//        pessoaRepository.findById(idPessoa);
//        return enderecoRepository.listByIdPessoa(idPessoa).stream()
//                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
//                .collect(Collectors.toList());
//    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException{
        findById(idEndereco);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        enderecoEntity.setIdEndereco(idEndereco);
        EnderecoEntity atualizado = enderecoRepository.save(enderecoEntity);

        return objectMapper.convertValue(atualizado, EnderecoDTO.class);
    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException{
        EnderecoEntity enderecoEntity = findById(idEndereco);
        enderecoRepository.delete(enderecoEntity);
    }

}
