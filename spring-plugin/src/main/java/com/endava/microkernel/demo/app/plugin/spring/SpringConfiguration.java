package com.endava.microkernel.demo.app.plugin.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class SpringConfiguration {

    @Bean
    public MessageProvider messageProvider() {
        return new MessageProviderImpl();
    }
}
