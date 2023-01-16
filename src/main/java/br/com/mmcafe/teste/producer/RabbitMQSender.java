package br.com.mmcafe.teste.producer;

import br.com.mmcafe.teste.model.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Queue queue;

    public void send(String fila, Image image) {
        rabbitTemplate.convertAndSend(fila, image);
        log.info("Sending Message to the Queue : " + image.toString());
    }
}
