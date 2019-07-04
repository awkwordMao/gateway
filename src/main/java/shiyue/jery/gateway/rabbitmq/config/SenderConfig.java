package shiyue.jery.gateway.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jery
 * @date 2019/6/28
 */
@Configuration
public class SenderConfig {

//    @Bean
//    public Queue queue(){
//        return new Queue("queue");
//    }
    @Bean
    public Queue queue(){
        return new Queue("exchange");
    }

}
