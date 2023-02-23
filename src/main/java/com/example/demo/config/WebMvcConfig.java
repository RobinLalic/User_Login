package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry controllerRegistry)
    {
        controllerRegistry.addViewController("/access-denied").setViewName("access-denied");
        controllerRegistry.addViewController("/").setViewName("homepage");
        controllerRegistry.addViewController("/about-us").setViewName("about-us");
    }
}
