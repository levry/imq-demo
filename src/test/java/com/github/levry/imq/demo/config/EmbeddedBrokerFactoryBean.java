package com.github.levry.imq.demo.config;

import com.github.levry.imq.embedded.EmbeddedBroker;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author levry
 */
public class EmbeddedBrokerFactoryBean implements FactoryBean<EmbeddedBroker>, InitializingBean, DisposableBean {

    private EmbeddedBroker embeddedBroker;

    @Override
    public void afterPropertiesSet() {
        embeddedBroker = EmbeddedBroker.builder().homeTemp().build();
        embeddedBroker.run();
    }

    @Override
    public EmbeddedBroker getObject() {
        return embeddedBroker;
    }

    @Override
    public Class<?> getObjectType() {
        return EmbeddedBroker.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void destroy() {
        if(embeddedBroker.isRunning()) {
            embeddedBroker.stop();
        }
    }
}
