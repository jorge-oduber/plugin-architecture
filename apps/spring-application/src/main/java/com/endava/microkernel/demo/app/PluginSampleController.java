package com.endava.microkernel.demo.app;

import javax.annotation.Resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Shawn Deng
 * @date 2021-06-03 16:48:18
 */
@RestController
public class PluginSampleController {

    @Resource
    private Greetings greetings;

    @Autowired
    private PluginManager pluginManager;

    @ApiOperation(value = "Execute all plugins", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Successfully executed plugin"),})
    @GetMapping("/plugins/all")
    public ResponseEntity<String> executeAllPlugins() {
        greetings.printGreetings();
        return ResponseEntity.ok("Hello World Plugin");
    }


    @ApiOperation(value = "Request to pluginIds", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Successfully executed plugin"),})
    @GetMapping(value = "plugins/", produces = "application/json")
    public String getPluginIds() {
        return pluginManager.getPlugins().stream().map(PluginWrapper::getPluginId).collect(
                Collectors.toList()).toString();
    }

}
