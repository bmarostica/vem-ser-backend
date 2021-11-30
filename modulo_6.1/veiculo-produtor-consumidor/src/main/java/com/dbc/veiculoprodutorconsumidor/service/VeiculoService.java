package com.dbc.veiculoprodutorconsumidor.service;

import com.dbc.veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.dbc.veiculoprodutorconsumidor.entity.VeiculoEntity;
import com.dbc.veiculoprodutorconsumidor.repository.VeiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final ObjectMapper objectMapper;
    private final VeiculoRepository veiculoRepository;

    public VeiculoDTO create(VeiculoDTO veiculoDTO) {
        VeiculoEntity veiculoEntity = objectMapper.convertValue(veiculoDTO, VeiculoEntity.class);
        VeiculoEntity troca = veiculoRepository.save(veiculoEntity);
        return objectMapper.convertValue(troca, VeiculoDTO.class);
    }

    public List<VeiculoDTO> list(){
        return veiculoRepository.findAll().stream()
                .map(troca -> objectMapper.convertValue(troca, VeiculoDTO.class))
                .collect(Collectors.toList());

    }

    public Double mediaVelocidadeTodos(){
        return veiculoRepository.mediaVelocidadeTodos();
    }

    public Double mediaRotacaoTodos(){
        return veiculoRepository.mediaRotacaoTodos();
    }

    public long count(){
        return veiculoRepository.count();
    }






}
