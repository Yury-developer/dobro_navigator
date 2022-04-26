package ru.dobro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dobro.domain.Message;
import ru.dobro.domain.User;
import ru.dobro.repos.MessageRepo;

import java.time.LocalDateTime;
import java.util.Map;


@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")   // теперь делаем ее корнем
    public String greeting(Map<String, Object> model) {
        String message = "Current date and time: " + LocalDateTime.now().toString();
        model.put("message", message);
        return "greeting";
    }



    @GetMapping("/main")   // теперь запэпим на   main
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }



    @PostMapping("/main")   // теперь запэпим на   main
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag, user);

        messageRepo.save(message);   // сохранили.

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);   // взяли из репозитория и отдем пользователю.

//        model.put("name_of_user", "привет из контроллера");

        return "main";
    }
    /*
    @RequestParam выдергивает из наших запросов
    (либо из формы, если мы передаем 'post', либо из 'url', если передаем 'get' запросом)
    значения. Используем короткую форму. Спринг попытается выдергнуть поля по имени 'text' и 'tag'
     */



    @PostMapping("filter")   // мы поменяли во вьюшке mapping. Теперь он указывается как 'filter'
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        // идем в репу 'MessageRepo' и создаем новый метод, затем:
        Iterable<Message> messages;   // общий интерфейс для возвращаемых 'List' и 'Iterable'

        if (filter != null && !filter.isEmpty()) {   // если фильтр не пуст - то ищем по тэгу, иначем просто возвращаем весь список
            messages = messageRepo.findByTag(filter);   // возвращает 'List'
        } else {
            messages = messageRepo.findAll();   // возвращает 'Iterable'
        }
        model.put("messages", messages);   // взяли из репозитория и отдем пользователю.

        return "main";
    }
    /*
    Чтобы хранить пользователя в базе. Для этого добавим в базу новый объект   user
    и доп. объект, кот. не будет напрямую храниться в  DB   - это роль   Role .
     */

}