package com.hive.hiveojbackendquestionservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
@MapperScan("com.hive.hiveojbackendquestionservice.mapper")
@EnableScheduling
@EnableDiscoveryClient
@ComponentScan("com.hive")
@EnableFeignClients(basePackages = {"com.hive.hiveojbackendserviceclient.service"})
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class HiveojBackendQuestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiveojBackendQuestionServiceApplication.class, args);
    }

}
