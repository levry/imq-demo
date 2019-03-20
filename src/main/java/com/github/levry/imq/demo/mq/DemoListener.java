package com.github.levry.imq.demo.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.adapter.JmsResponse;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @author levry
 */
@Slf4j
@Component
public class DemoListener {

    @JmsListener(destination = "imq.demo")
    public JmsResponse<String> hello(Message<String> message) {
        log.debug("Received message: {}", message);

        Destination replyTo = message.getHeaders().get("jms_replyTo", Destination.class);
        return responseFor(message, replyTo);
    }

    private JmsResponse<String> responseFor(Message<String> message, Destination replyTo) {
        if (null == replyTo) {
            return null;
        }

        return JmsResponse.forDestination("Hello, " + message.getPayload(), replyTo);
    }

}
