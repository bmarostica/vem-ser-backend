package com.dbc.chatkafka.service;

import com.dbc.chatkafka.DTO.MensagemDTO;
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


@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic.geral}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactoryLatest",
            clientIdPrefix = "chatGeral"
    )
    public void consume(@Payload String mensagem,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info("{}/{}/{} {}:{}:{}, [{}]:, {}",
                mensagemDTO.getDataCriacao().getDayOfMonth(),
                mensagemDTO.getDataCriacao().getMonthValue(),
                mensagemDTO.getDataCriacao().getYear(),
                mensagemDTO.getDataCriacao().getHour(),
                mensagemDTO.getDataCriacao().getMinute(),
                mensagemDTO.getDataCriacao().getSecond(),
                mensagemDTO.getUsuario(),
                mensagemDTO.getMensagem());
    }

    @KafkaListener(
            topics = "${kafka.topic.bianca}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactoryEarliest",
            clientIdPrefix = "chatPrivado"
    )
    public void consumeDto(@Payload String mensagem,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info("{}/{}/{} {}:{}:{}, [{}] (privada):, {}",
                mensagemDTO.getDataCriacao().getDayOfMonth(),
                mensagemDTO.getDataCriacao().getMonthValue(),
                mensagemDTO.getDataCriacao().getYear(),
                mensagemDTO.getDataCriacao().getHour(),
                mensagemDTO.getDataCriacao().getMinute(),
                mensagemDTO.getDataCriacao().getSecond(),
                mensagemDTO.getUsuario(),
                mensagemDTO.getMensagem());
    }

}
