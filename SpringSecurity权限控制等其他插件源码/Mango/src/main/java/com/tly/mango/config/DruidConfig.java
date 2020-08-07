package com.tly.mango.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;

/**
 * 配置Servlet和Filter过滤
 * 主要是注入属性和配置连接池相关的配置信息 如黑白名单、监控管理后台登录账户密码等。
 * */
@Configuration
@EnableConfigurationProperties({DruidDataSourceProperties.class})//将上一个配置界面引入进来
public class DruidConfig {

//    @Autowired
//    private DruidDataSourceProperties properties;

      //如果需要用到自定义数据源配置则打开进行配置
//    @Bean
//    @ConditionalOnMissingBean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource(){
//        return new DruidDataSource();
//    }


    @Bean
    @ConditionalOnMissingBean
    public ServletRegistrationBean<Servlet> druidServlet(){
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<Servlet>(new StatViewServlet(),"/druid/*");
        //白名单
        servletServletRegistrationBean.addInitParameter("allow","192.168.0.112");
        //IP黑名单
        servletServletRegistrationBean.addInitParameter("deny","192.168.0.112");
        //登录查看信息的账号密码 ,用于登录Druid监控后台
        servletServletRegistrationBean.addInitParameter("loginUsername","admin");
        servletServletRegistrationBean.addInitParameter("loginPassword","admin");
        //是否能够重复数据
        servletServletRegistrationBean.addInitParameter("resetEnable","true");
        return servletServletRegistrationBean;
    }


    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> frb = new FilterRegistrationBean<>();
        frb.setFilter(new WebStatFilter());
        // 所有请求进行监控处理
        frb.addUrlPatterns("/*");
        // 放行
        frb.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*,/user/*");
        return frb;
    }
}
