package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.EmailDTO;
import com.dbc.pessoaapi.kafka.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final Producer producer;

    @PostMapping("/enviar")
    public void enviar(@RequestBody EmailDTO emailDTO) throws JsonProcessingException {
        producer.sendEmail(emailDTO);
    }

}
