package com.tly.mango;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = "com.tly.mango.repository")
@Configuration
@EnableCaching
@ServletComponentScan
//@EnableAdminServer
@SpringBootApplication(scanBasePackages={"com.tly.mango"})
public class MangoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoApplication.class, args);
    }

}
