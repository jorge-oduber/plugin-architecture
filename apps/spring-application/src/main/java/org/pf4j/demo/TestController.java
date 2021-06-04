package org.pf4j.demo;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Shawn Deng
 * @date 2021-06-03 16:48:18
 */
@RestController
public class TestController {

    @Resource
    private Greetings greetings;

    @GetMapping("/simple/get")
    public ResponseEntity<String> simpleGet() {
        greetings.printGreetings();
        return ResponseEntity.ok("Hello World Plugin");
    }
}
