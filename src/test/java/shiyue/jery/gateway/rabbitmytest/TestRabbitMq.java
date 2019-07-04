package shiyue.jery.gateway.rabbitmytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Jery
 * @date 2019/6/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestRabbitMq {
    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("exchange_1", "key_1", "第一个消息");

    }

    @Test
    public void send1() {
        rabbitTemplate.convertAndSend("exchange", "11111");
    }

    @Test
    public void fanout() throws InterruptedException {
        String meg = "fanout：广播消息";
        for (int i = 0; i < 5; i++) {

            amqpTemplate.convertAndSend("exchange_1", "", meg + i);
            System.out.println("发送 " + i);
            Thread.sleep(2000);
        }
    }

    @Test
    public void direct() throws InterruptedException {
        String msg = "direct: 路由消息";
        for (int i = 0; i < 5; i++) {
            amqpTemplate.convertAndSend("exchange_1", "direct", msg + i);
            Thread.sleep(1000);
            System.out.println("发送：" + i);
        }
    }

    @Test
    public void topic() throws InterruptedException {
        String msg = "topic: 路由消息";
        amqpTemplate.convertAndSend("exchange_2", "topic.one", "topic one");
        System.out.println("topic.one 发送");
        amqpTemplate.convertAndSend("exchange_2", "topic.one.two", "topic one");
        System.out.println("topic.one 发送");
        amqpTemplate.convertAndSend("exchange_2", "topic1.one", "topic one");
        System.out.println("topic.one 发送");
        amqpTemplate.convertAndSend("exchange_2", "topic1.two", "topic one");
        System.out.println("topic.one 发送");
    }
}
