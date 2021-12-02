package com.dbc.emailconsumidor.service;

import com.dbc.emailconsumidor.dto.EmailDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;


@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    @KafkaListener(
            topics = "${kafka.topic.email}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactoryLatest")
    public void consume(@Payload String mensagem) throws IOException, MessagingException, TemplateException {
        EmailDTO emailDTO = objectMapper.readValue(mensagem, EmailDTO.class);
        emailService.enviarEmail(emailDTO);
        log.info("Mensagem: {}", emailDTO);
    }
}
