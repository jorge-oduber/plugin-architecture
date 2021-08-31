package com.endava.microkernel.demo.app;

import org.pf4j.PluginManager;
import org.pf4j.spring.SpringPluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

/**
 *
 * @author Shawn Deng
 * @date 2021-06-03 19:28:07
 */
@Configuration(proxyBeanMethods = false)
public class SpringConfig {

    private static final Logger logger = LoggerFactory.getLogger(SpringConfig.class);

    @Bean
    public SpringPluginManager pluginManager() {
        logger.info("Init pluginManager");
        return new SpringPluginManager();
    }

    @Bean
    @DependsOn("pluginManager")
    public Greetings greetings() {
        logger.info("Init Greetings Bean");
        return new Greetings();
    }

    @EventListener
    public void handleContextStopEvent(ContextClosedEvent event) {
        logger.info("Stop Plugin......");
        event.getApplicationContext().getBean(PluginManager.class).stopPlugins();
    }
}
