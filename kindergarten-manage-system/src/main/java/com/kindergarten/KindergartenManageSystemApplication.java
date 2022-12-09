package com.kindergarten;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kindergarten.*.mapper")
@Slf4j
public class KindergartenManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(KindergartenManageSystemApplication.class, args);
        log.info("I am OK！");
    }

}
