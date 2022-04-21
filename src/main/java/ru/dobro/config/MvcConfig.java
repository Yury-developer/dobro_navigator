package ru.dobro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



/*
В этом классе содержится конфигурация нашего web - слоя
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/home").setViewName("home");   // в этом случае - свой контроллер не создаем. есть странички, шаблоны, на которых нет никакой логики. Можно удалять!
//        registry.addViewController("/").setViewName("home");
//        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");   // Логика системная, она нас устраивает, нам нужен только login - шаблон, который мы сделаем (страничку)
    }

}