package shiyue.jery.gateway.rabbitmq.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jery
 * @date 2019/6/28
 */
@Configuration
public class RabbitConfig {

    @Autowired
    RabbitTemplate rabbitTemplate;

}
