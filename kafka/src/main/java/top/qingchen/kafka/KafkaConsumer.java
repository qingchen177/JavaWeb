package top.qingchen.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    //监听消费
    @KafkaListener(topics = {"topic-test"})
    public void onNormalMessage(ConsumerRecord<String, Object> record) {
        System.out.println("简单消费：" + record.topic() + "-" + record.partition() + "=" +
                record.value());
    }

}
