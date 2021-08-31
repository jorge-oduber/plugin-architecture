package com.endava.microkernel.demo.app.welcome;

import org.apache.commons.lang3.StringUtils;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;
import com.endava.microkernel.demo.model.api.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FancyPlugin extends Plugin {

    private static final Logger logger = LoggerFactory.getLogger(FancyPlugin.class);

    public FancyPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
        logger.info(StringUtils.center("WelcomePlugin.start()", 4));
    }

    @Override
    public void stop() {
        logger.info("WelcomePlugin.stop()");
    }

    @Extension
    public static class WelcomeGreeting implements Greeting {

        @Override
        public String getGreeting() {
            return "Welcome Plugin .... FANCY!!!";
        }
    }

}
