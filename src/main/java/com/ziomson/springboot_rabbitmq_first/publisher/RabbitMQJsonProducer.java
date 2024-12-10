package com.ziomson.springboot_rabbitmq_first.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ziomson.springboot_rabbitmq_first.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key.json}")
    private String routingJsonKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user) {
        try {
            // Convert the User object to JSON string
            LOGGER.info(String.format("Json message sent -> %s", user.toString()));

            // Send the JSON message to RabbitMQ
            rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
        } catch (Exception e) {
            LOGGER.error("Error converting User to JSON", e);
        }
    }
}
