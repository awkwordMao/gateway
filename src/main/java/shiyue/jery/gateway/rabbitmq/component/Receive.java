package shiyue.jery.gateway.rabbitmq.component;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jery
 * @date 2019/6/28
 */
@Component
@Transactional
public class Receive {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("queue_1"),
            exchange = @Exchange("exchange_1"),
            key = ("key_1")
    ))
    public void getQueue(String string) {
        System.out.println("RabbitMq接收器: " + string);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("exchange_1_fanout_1"),
            exchange = @Exchange(value = "exchange_1",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT)
    ))
    public void getFanout(String string) {
        System.out.println("1  " + string);
    }
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue("exchange_1_fanout_2"),
//            exchange = @Exchange(value = "exchange_1",
//                    ignoreDeclarationExceptions = "true",
//                    type = ExchangeTypes.FANOUT)
//    ))
//    public void getFanout1(String strng) {
//        System.out.println("2  " + strng);
//    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(""),
            exchange = @Exchange(value = "exchange_1",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.DIRECT),
            key = "direct"
    ))
    public void getDirect(String string){
        System.out.println(string);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "topic.one.one", durable = "true"),
            exchange = @Exchange(value = "exchange_2", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"topic.#"}
    ))
    public void getTopic(String string){
        System.out.println("topic: " + string);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "topic1.one.one", durable = "true"),
            exchange = @Exchange(value = "exchange_2", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = "topic1.#"
    ))
    public void getTopic1(String string){
        System.out.println("topic1: " + string);
    }
}
