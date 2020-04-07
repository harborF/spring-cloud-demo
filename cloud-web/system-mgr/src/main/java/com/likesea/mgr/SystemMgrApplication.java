package com.likesea.mgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages="com.likesea.mgr")
@EnableEurekaClient
//@EnableDiscoveryClient
//@EnableHystrix//注解开启断路器
//@EnableCircuitBreaker
//@RefreshScope//配置自动刷新
public class SystemMgrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemMgrApplication.class, args);
    }
/*
    @Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean<DispatcherServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet);
        servletServletRegistrationBean.addUrlMappings("*.do");
        return servletServletRegistrationBean;
    }
*/

    @Bean
    @LoadBalanced//表明开启负载均衡
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

