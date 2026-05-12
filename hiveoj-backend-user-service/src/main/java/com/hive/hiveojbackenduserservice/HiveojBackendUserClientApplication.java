package com.hive.hiveojbackenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.hive.hiveojbackenduserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.hive")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.hive.hiveojbackendserviceclient.service"})
public class HiveojBackendUserClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiveojBackendUserClientApplication.class, args);
    }

}
