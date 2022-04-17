package ru.dobro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   // эта аннотация добавляет спец. обвесы, кот. найдут все контроллеры и т.д.
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
