package com.endava.microkernel.demo.model.api;

import org.pf4j.ExtensionPoint;

public interface Greeting extends ExtensionPoint {
    String getGreeting();
}
