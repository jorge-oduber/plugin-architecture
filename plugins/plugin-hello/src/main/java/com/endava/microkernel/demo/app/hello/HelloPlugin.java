package com.endava.microkernel.demo.app.hello;

import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;
import com.endava.microkernel.demo.model.api.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloPlugin extends Plugin {
    private static final Logger logger = LoggerFactory.getLogger(HelloPlugin.class);

    public HelloPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
        logger.info("HelloPlugin.start()");
    }

    @Override
    public void stop() {
        logger.info("HelloPlugin.stop()");
    }

    @Extension(ordinal = 1)
    public static class HelloGreeting implements Greeting {

        @Override
        public String getGreeting() {
            return "Hello plugin....";
        }

    }

}
