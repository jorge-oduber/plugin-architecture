package org.pf4j.demo.plugin.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Shawn Deng
 * @date 2021-06-03 17:47:57
 */
@Configuration(proxyBeanMethods = false)
public class SpringConfiguration {

    @Bean
    public MessageProvider messageProvider() {
        return new MessageProviderImpl();
    }
}
