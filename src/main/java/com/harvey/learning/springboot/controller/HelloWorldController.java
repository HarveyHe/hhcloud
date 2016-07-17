package com.harvey.learning.springboot.controller;

import com.harvey.learning.springboot.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

/**
 * Created by harvey on 16/7/14.
 */
@RestController
@RequestMapping("/springboot")
public class HelloWorldController {


    @Autowired
    private Environment environment;

    @Autowired
    UserConfig user;


    /**
     * eg. http://localhost:8080/he/springboot/harvey
     * @param name
     * @return
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String sayWorld(@PathVariable("name") String name) {
        System.out.println("userName:" + user.getName());
        System.out.println("remark:" + user.getRemark());
        String remark = environment.getProperty("remark");
        System.out.println("remark:"+remark);
        return "Hello " + name;
    }
}
