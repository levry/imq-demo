package com.github.levry.imq.demo;

import com.github.levry.imq.demo.config.ImqConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ImqConfig.class)
class ImqDemoApplicationTests {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    void sendAndReceiveMessage() throws JMSException {
        Message response = jmsTemplate.sendAndReceive("imq.demo",
                session -> session.createTextMessage("levry")
        );

        assertThat(response).isNotNull();
        assertThat(response).isInstanceOf(TextMessage.class);

        String text = ((TextMessage) response).getText();
        assertThat(text).isEqualToIgnoringCase("hello, levry");
    }

}
