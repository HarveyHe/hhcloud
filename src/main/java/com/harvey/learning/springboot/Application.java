package com.harvey.learning.springboot;

import com.harvey.learning.springboot.listener.MyApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by harvey on 16/7/14.
 */
@SpringBootApplication
public class Application {
    public  static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new MyApplicationStartedEventListener());
        app.run(args);
    }
}
