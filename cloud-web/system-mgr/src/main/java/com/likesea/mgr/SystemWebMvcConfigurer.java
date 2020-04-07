package com.likesea.mgr;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SystemWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseRegisteredSuffixPatternMatch(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean<DispatcherServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet);
        servletServletRegistrationBean.addUrlMappings("*.html");
        servletServletRegistrationBean.addUrlMappings("*.css");
        servletServletRegistrationBean.addUrlMappings("*.js");
        servletServletRegistrationBean.addUrlMappings("*.png");
        servletServletRegistrationBean.addUrlMappings("*.gif");
        servletServletRegistrationBean.addUrlMappings("*.ico");
        servletServletRegistrationBean.addUrlMappings("*.jpeg");
        servletServletRegistrationBean.addUrlMappings("*.jpg");
        servletServletRegistrationBean.addUrlMappings("*.ttf");
        servletServletRegistrationBean.addUrlMappings("*.woff");
        return servletServletRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SystemInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();

        List<HttpMessageConverter<?>> converters = adapter.getMessageConverters();

        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        MediaType textMedia = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        supportedMediaTypes.add(textMedia);
        MediaType jsonMedia = new MediaType(MediaType.APPLICATION_JSON, Charset.forName("UTF-8"));
        supportedMediaTypes.add(jsonMedia);jsonConverter.setSupportedMediaTypes(supportedMediaTypes);

        converters.add(jsonConverter);

        adapter.setMessageConverters(converters);

        return adapter;
    }
}
