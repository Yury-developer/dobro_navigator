package ru.dobro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dobro.beans.Message;
import ru.dobro.beans.User;
import ru.dobro.repos.MessageRepo;

import java.util.Map;


@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")   // теперь делаем ее корнем
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }



    @GetMapping("/main")   // теперь запэпим на   main
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {   // 'required = false' -т.е. мы не всегда его будем передавать.   'defaultValue = ""' - для того, чтобы не сломалось, когда фильтр не указан
        Iterable<Message> messages = messageRepo.findAll();

        if (filter != null && !filter.isEmpty()) {   // если фильтр не пуст - то ищем по тэгу, иначем просто возвращаем весь список
            messages = messageRepo.findByTag(filter);   // возвращает 'List'
        } else {
            messages = messageRepo.findAll();   // возвращает 'Iterable'
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

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


}