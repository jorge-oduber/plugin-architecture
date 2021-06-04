package org.pf4j.demo;

import java.util.List;

import org.pf4j.demo.api.Greeting;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Shawn Deng
 * @date 2021-06-03 19:30:34
 */
public class Greetings {

    @Autowired
    private List<Greeting> greetings;

    public void printGreetings() {
        System.out.format("Found %d extensions for extension point '%s' \n", greetings.size(), Greeting.class.getName());
        System.out.println("Plugin output......");
        for (Greeting greeting : greetings) {
            System.out.println(">>> " + greeting.getGreeting());
        }
    }
}
