package org.pf4j.demo;

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
        // !!! Must Init Spring Plugin Manager，load plugins in this plugin bean
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
        PluginManager pluginManager = event.getApplicationContext().getBean(PluginManager.class);
        // !!!! Very Important, we must trigger plugin stop event method in case plugin stop method has something to do
        pluginManager.stopPlugins();
    }
}
