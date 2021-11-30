package com.dbc.chatkafka.kafka;

import com.dbc.chatkafka.DTO.MensagemCreateDTO;
import com.dbc.chatkafka.DTO.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.topic.geral}")
    private String topicoGeral;

    public void send(MensagemDTO mensagem, String topico) throws JsonProcessingException {
        String payload = objectMapper.writeValueAsString(mensagem);
        Message<String> message = MessageBuilder.withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .build();

        ListenableFuture<SendResult<String, String>> send = stringKafkaTemplate.send(message);

        send.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao enviar mensagem ao kafka, texto: {}", mensagem);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("{} [{}] para: ({}): {}",
                        mensagem.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                        mensagem.getUsuario(),
                        StringUtils.capitalize(topico.replaceAll("chat-", "")),
                        mensagem.getMensagem());
            }
        });

    }

    public void sendMessageGeral(MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        mensagemDTO.setUsuario("Bianca");

        send(mensagemDTO, topicoGeral);
    }

    public void sendMessagePrivada(MensagemCreateDTO mensagemCreateDTO, String topico) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        mensagemDTO.setUsuario("Bianca");
        send(mensagemDTO, "chat-" + topico);
    }
}
