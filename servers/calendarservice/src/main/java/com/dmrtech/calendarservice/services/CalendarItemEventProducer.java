package com.dmrtech.calendarservice.services;

import com.dmrtech.calendarservice.model.CalendarItemEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CalendarItemEventProducer {

    @Value(value = "${kafka.calendarItemTopicName}")
    private String calendarItemTopicName;

    private KafkaTemplate<String, CalendarItemEvent> kafkaTemplate;

    public CalendarItemEventProducer(KafkaTemplate<String, CalendarItemEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CalendarItemEvent msg) {
        kafkaTemplate.send(calendarItemTopicName, msg);
    }
}
