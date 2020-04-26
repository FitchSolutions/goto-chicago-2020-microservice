package com.dmrtech.calendarservice.configuration;


import com.dmrtech.calendarservice.model.CalendarItemEvent;
import org.junit.Test;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Parasoft Jtest UTA: Test class for KafkaConsumerConfig
 *
 * @author dferguson
 * @see KafkaConsumerConfig
 */
public class KafkaConsumerConfigTest {
    /**
     * Parasoft Jtest UTA: Test for consumerConfigs()
     *
     * @author dferguson
     * @see KafkaConsumerConfig#consumerConfigs()
     */
    @Test(timeout = 1000)
    public void testConsumerConfigs() throws Throwable {
        // Given
        KafkaConsumerConfig underTest = new KafkaConsumerConfig();

        // When
        Map<String, Object> result = underTest.consumerConfigs();

        // Then
        assertNotNull(result);
        Object o = result.get("group.id");
        assertNotNull(o);
        assertEquals(40, o.toString().length());
        // assertEquals(0, result.size());
        // assertTrue(result.containsKey(""));
        // assertTrue(result.containsValue(null));
    }

    /**
     * Parasoft Jtest UTA: Test for consumerFactory()
     *
     * @author dferguson
     * @see KafkaConsumerConfig#consumerFactory()
     */
    @Test(timeout = 1000)
    public void testConsumerFactory() throws Throwable {
        // Given
        KafkaConsumerConfig underTest = new KafkaConsumerConfig();

        // When
        ConsumerFactory<String, CalendarItemEvent> result = underTest.consumerFactory();

        // Then
        assertNotNull(result);
        Map<String, Object> configurationProperties = result.getConfigurationProperties();
        assertNotNull(configurationProperties);
        Object o = configurationProperties.get("group.id");
        assertNotNull(o);
        assertEquals(40, o.toString().length());

    }

    /**
     * Parasoft Jtest UTA: Test for kafkaListenerContainerFactory()
     *
     * @author dferguson
     * @see KafkaConsumerConfig#kafkaListenerContainerFactory()
     */
    @Test(timeout = 1000)
    public void testKafkaListenerContainerFactory() throws Throwable {
        // Given
        KafkaConsumerConfig underTest = new KafkaConsumerConfig();

        // When
        KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, CalendarItemEvent>> result = underTest.kafkaListenerContainerFactory();

        // Then
        assertNotNull(result);

    }
}