package org.pf4j.demo.plugin.spring;

import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Shawn Deng
 * @date 2021-06-03 17:50:14
 */
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
        // 父类会关闭上下文
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
