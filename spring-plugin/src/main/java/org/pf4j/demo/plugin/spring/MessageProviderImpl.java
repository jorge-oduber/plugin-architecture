package org.pf4j.demo.plugin.spring;

/**
 *
 * @author Shawn Deng
 * @date 2021-06-03 17:47:13
 */
public class MessageProviderImpl implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello, I am Spring Plugin";
    }
}
