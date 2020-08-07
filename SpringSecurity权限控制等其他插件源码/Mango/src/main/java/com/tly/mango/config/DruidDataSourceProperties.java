package com.tly.mango.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;
/**
 * 通过配置文件applicaition.yml进行的配置信息
 * Druid进行自定义属性配置
 *
 * 配置参考地址
 * https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter
 * */

@ConfigurationProperties(prefix = "spring.datasource.druid")
@Data
public class DruidDataSourceProperties {
    private String driverClassName = " com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/demo_sys?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    private String username = "root";
    private String password = "123456";
    private int initialSize;
    private int minIdle;
    private int maxActive = 100;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private String filters;
}
