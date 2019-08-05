package com.itzy.gatewayservice;

import com.itzy.commonservice.annotation.ZyMicroServiceApplication;
import org.springframework.boot.SpringApplication;

@ZyMicroServiceApplication
public class GatewayServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

}
