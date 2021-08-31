package com.endava.microkernel.demo.app.plugin.spring;

public class MessageProviderImpl implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello, I am Spring Plugin";
    }
}
