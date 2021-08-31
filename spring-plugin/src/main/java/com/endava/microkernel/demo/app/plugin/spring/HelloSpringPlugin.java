package com.endava.microkernel.demo.app.plugin.spring;

import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloSpringPlugin extends SpringPlugin {

    public HelloSpringPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
        System.out.println("HelloSpringPlugin.start()");
    }

    @Override
    public void stop() {
        System.out.println("HelloSpringPlugin.stop()");
        super.stop();
    }

    @Override
    protected ApplicationContext createApplicationContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
        applicationContext.register(SpringConfiguration.class);
        applicationContext.refresh();
        return applicationContext;
    }
}
