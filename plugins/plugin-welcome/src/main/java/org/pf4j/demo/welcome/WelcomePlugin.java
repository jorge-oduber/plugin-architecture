package org.pf4j.demo.welcome;

import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;
import org.pf4j.demo.api.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WelcomePlugin extends Plugin {

    private static final Logger logger = LoggerFactory.getLogger(WelcomePlugin.class);

    public WelcomePlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
        logger.info("WelcomePlugin.start()");
    }

    @Override
    public void stop() {
        logger.info("WelcomePlugin.stop()");
    }

    @Extension
    public static class WelcomeGreeting implements Greeting {

        @Override
        public String getGreeting() {
            return "Welcome Plugin ....";
        }
    }

}
