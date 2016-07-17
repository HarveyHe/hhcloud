package com.harvey.learning.springboot.controller;

import com.harvey.learning.springboot.Entity.DemoEntity;
import com.harvey.learning.springboot.config.UserConfig;
import com.harvey.learning.springboot.model.BasUsersModel;
import com.harvey.learning.springboot.service.BasUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    BasUsersService basUsersService;


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

    @RequestMapping(value = "/get/list.json", method = RequestMethod.GET)
    @ResponseBody
    public List<DemoEntity> getDemoList(){
        List<DemoEntity> lists = new ArrayList<DemoEntity>();
        for (int i = 0 ;i < 10 ; i++){
            DemoEntity demoEntity = new DemoEntity();
            demoEntity.setAge(i);
            demoEntity.setName("harvey" + i);
            lists.add(demoEntity);
        }
        return lists;

    }
    @RequestMapping(value = "/get/userlist.json", method = RequestMethod.GET)
    @ResponseBody
    public List<BasUsersModel> getUsersList(){
        List<BasUsersModel> lists = new ArrayList<BasUsersModel>();
        lists = this.basUsersService.query();
        return lists;

    }
}
