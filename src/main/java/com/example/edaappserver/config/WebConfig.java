package com.example.edaappserver.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
/**
 * Этот метод используется для добавления обработчиков ресурсов в реестр.
 * Обработчики ресурсов определяют, как обрабатывать запросы к определенным ресурсам.
 * В данном случае, все запросы, которые начинаются с "/files/**", будут обрабатываться
 * как запросы к ресурсам, расположенным в "classpath:/static/files/".
 *
 * @param registry Реестр обработчиков ресурсов, в который добавляются обработчики.
 */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**")
                //.addResourceLocations("classpath:/static/files/")
                //указана моя папка внешняя, в которой хранятся картинки
                .addResourceLocations("file:/G:/ServerPictures/");
    }

//    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/login").setViewName("login");
//    }
}
