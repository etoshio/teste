package br.com.mmcafe.teste.consumer;

import br.com.mmcafe.teste.model.Image;
import br.com.mmcafe.teste.repository.ImageRepository;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "rabbitmq.queue", id = "listener")
public class RabbitMQReceiver {

    @Autowired
    ImageRepository repository;

    @RabbitHandler
    public void receiver(Image image) {
        repository.save(image);
    }
}