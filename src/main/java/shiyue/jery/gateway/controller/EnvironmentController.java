package shiyue.jery.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jery
 * @date 2019/6/27
 */
@RestController
public class EnvironmentController {

    @Autowired
    Environment environment;

    @GetMapping("/getvalue")
    public String getValue(){
        System.out.println(environment.getProperty("my.name"));
        return environment.getProperty("my.name") + " = value";
    }
}
