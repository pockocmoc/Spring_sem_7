package com.pockocmoc.homework7.securingweb;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Конфигурация MVC.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Добавляет контроллеры представлений для различных URL-адресов.
     *
     * @param registry реестр контроллеров представлений
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/private-data").setViewName("private-data");
        registry.addViewController("/public-data").setViewName("public-data");
    }

}