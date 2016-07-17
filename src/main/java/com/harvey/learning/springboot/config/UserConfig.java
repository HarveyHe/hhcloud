package com.harvey.learning.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by harvey on 16/7/14.
 */
@Component
public class UserConfig {
    private @Value("${userName}") String name;
    private @Value("${age}") Integer    age;
    private @Value("${remark}") String     remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
