package com.hmp.kafkaexample.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

public class KafkaConsumer {
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name("testTopic")
                .partitions(10)
                .replicas(1)
                .build();
    }
    @KafkaListener(id="myId",topics = "testTopic")
    public void listen(String in){
        System.out.println(in);
    }
}
