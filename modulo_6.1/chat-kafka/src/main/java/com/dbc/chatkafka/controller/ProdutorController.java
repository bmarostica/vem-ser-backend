package com.dbc.chatkafka.controller;

import com.dbc.chatkafka.DTO.MensagemCreateDTO;
import com.dbc.chatkafka.kafka.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final Producer producer;

    @PostMapping("/chat-geral")
    public void mensagemGeral(@RequestBody MensagemCreateDTO mensagem) throws JsonProcessingException {
        producer.sendMessageGeral(mensagem);
    }

    @PostMapping("/chat-bianca")
    public void mensagemPrivada(@RequestBody MensagemCreateDTO mensagem, @RequestParam String topico) throws JsonProcessingException {
       producer.sendMessagePrivada(mensagem, topico);
    }

}
