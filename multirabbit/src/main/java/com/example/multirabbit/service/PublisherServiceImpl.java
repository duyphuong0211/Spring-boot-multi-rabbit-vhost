package com.example.multirabbit.service;

import com.example.multirabbit.events.MessageEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.connection.SimpleResourceHolder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(MessageEvent event) {
        try {
            SimpleResourceHolder.bind(rabbitTemplate.getConnectionFactory(), event.getClientId());
            log.info("PUBLISHING : " + event.toString());
            rabbitTemplate.convertAndSend(event.getExchange(), event.getRoutingKey(), event.getMessage());
        } catch (Exception e) {
            log.error("Exception ", e);
        } finally {
            SimpleResourceHolder.unbindIfPossible(rabbitTemplate.getConnectionFactory());
        }

    }
}
