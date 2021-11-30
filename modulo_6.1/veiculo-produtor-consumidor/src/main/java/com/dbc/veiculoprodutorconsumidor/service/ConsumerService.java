package com.dbc.veiculoprodutorconsumidor.service;

import com.dbc.veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.dbc.veiculoprodutorconsumidor.entity.VeiculoEntity;
import com.dbc.veiculoprodutorconsumidor.repository.VeiculoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ObjectMapper objectMapper;
    private final VeiculoService veiculoService;


    @KafkaListener(
            topics = "${kafka.topic.dto}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactoryEarliest"
    )
    public void consumeDto(@Payload String mensagem,
                           @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                           @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        VeiculoDTO veiculoDTO = objectMapper.readValue(mensagem, VeiculoDTO.class);
        veiculoService.create(veiculoDTO);
        log.info("MENSAGEM LIDA: '{}', CHAVE: '{}', OFFSET: '{}'", veiculoDTO, key, offset);
    }



}
