package com.github.levry.imq.demo.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author levry
 */
@TestConfiguration
public class ImqConfig {

    @Bean
    EmbeddedBrokerFactoryBean embeddedBroker() {
        return new EmbeddedBrokerFactoryBean();
    }

}
