package org.pf4j.demo.plugin.spring;

import javax.annotation.Resource;

import org.pf4j.Extension;
import org.pf4j.demo.api.Greeting;

/**
 *
 * @author Shawn Deng
 * @date 2021-06-03 17:45:01
 */
@Extension(ordinal = 1)
public class HelloGreeting implements Greeting {

    @Resource
    private MessageProvider messageProvider;

    @Override
    public String getGreeting() {
        return messageProvider.getMessage();
    }
}
