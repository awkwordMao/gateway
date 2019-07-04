package shiyue.jery.gateway.rabbitmq.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jery
 * @date 2019/6/28
 */
@Component
public class HelloSend {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(){
        amqpTemplate.convertAndSend("queue", "hello,rabbitqm···");
    }
}
