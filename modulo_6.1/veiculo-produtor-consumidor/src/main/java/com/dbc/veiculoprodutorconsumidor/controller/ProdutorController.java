package com.dbc.veiculoprodutorconsumidor.controller;

import com.dbc.veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.dbc.veiculoprodutorconsumidor.kafka.Producer;
import com.dbc.veiculoprodutorconsumidor.service.VeiculoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final Producer producer;
    private final VeiculoService veiculoService;

    @PostMapping("/enviar")
    public void enviar(@RequestBody VeiculoDTO veiculoDTO) throws JsonProcessingException {
        producer.sendMessage(veiculoDTO);
    }

    @GetMapping("/lista-tudo")
    public List<VeiculoDTO> list() {
        return veiculoService.list();
    }

    @GetMapping("/media-velocidade")
    public Double mediaVelocidadeTodos() {
        return veiculoService.mediaVelocidadeTodos();
    }

    @GetMapping("/media-rotacao")
    public Double mediaRotacaoTodos() {
        return veiculoService.mediaRotacaoTodos();
    }

    @GetMapping("/quantidade")
    public long count(){
        return veiculoService.count();
    }


}
