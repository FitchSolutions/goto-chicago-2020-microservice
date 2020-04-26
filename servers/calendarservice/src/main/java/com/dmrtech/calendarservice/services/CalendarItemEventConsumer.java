package com.dmrtech.calendarservice.services;

import com.dmrtech.calendarservice.model.CalendarItem;
import com.dmrtech.calendarservice.model.CalendarItemEvent;
import com.dmrtech.calendarservice.repository.CalendarItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalendarItemEventConsumer {

    private static final Logger logger = LoggerFactory.getLogger(CalendarItemEventConsumer.class);

    private final CalendarItemRepository calendarItemRepository;

    public CalendarItemEventConsumer(CalendarItemRepository calendarItemRepository) {
        this.calendarItemRepository = calendarItemRepository;
    }

    @KafkaListener(id="calendaritems", topics = "${kafka.calendarItemTopicName}",autoStartup = "true")
    public void calendarItemEventListener(CalendarItemEvent calendarItemEvent) {
        logger.info("received message {}", calendarItemEvent);

        CalendarItemEvent.EVENT_TYPE eventType = calendarItemEvent.getEventType();

        switch(eventType) {
            case CREATED:
            case UPDATED:
                createOrUpdateCalendarEvent(calendarItemEvent);
                break;

            case DELETED:
                deleteCalendarEventHandler(calendarItemEvent);
        }
    }

    private void createOrUpdateCalendarEvent(CalendarItemEvent calendarItemEvent) {
        CalendarItem incomingCalendarEvent = calendarItemEvent.getCalendarItem();

        // then do the legacy processing
        Optional<CalendarItem> calendarItemLookup = calendarItemRepository.findById(incomingCalendarEvent.getID());

        if(calendarItemLookup.isPresent() ) {
            CalendarItem calendarItem = calendarItemLookup.get();
            calendarItem.setDate(incomingCalendarEvent.getDate());
            calendarItem.setAllDayEvent(incomingCalendarEvent.isAllDayEvent());
            calendarItem.setTitle(incomingCalendarEvent.getTitle());
            calendarItem.setDetails(incomingCalendarEvent.getDetails());

            logger.info("Saved calendar event: {}", calendarItem);
             calendarItemRepository.save(calendarItem);
        } else {

            logger.info("Created calendar event {}", incomingCalendarEvent);
            calendarItemRepository.save(incomingCalendarEvent);
        }
    }

    private void deleteCalendarEventHandler(CalendarItemEvent calendarItemEvent) {
        Long calendarToDelete = calendarItemEvent.getCalendarItem().getID();
        logger.info("deleted item {}", calendarToDelete);
        calendarItemRepository.deleteById(calendarToDelete);
    }
}
