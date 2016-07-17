package com.harvey.learning.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public final class Config {
    @Autowired
    private static Environment environment ;
    
    public static String get(String key) {
        return environment.getProperty(key);
    }


}
