package com.itzy.commonplugin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CommonPluginApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonPluginApplication.class, args);
    }

}
