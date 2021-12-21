package com.example.hrsample.amq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JmsProducer {
    private final JmsTemplate jmsTemplate;

    @Value("${activemq.queue.name}")
    String destination;

    public void send(String message) {
        jmsTemplate.convertAndSend(destination, message);
        log.info("Sent message='{}'", message);
    }
}
