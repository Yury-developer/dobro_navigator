package ru.dobro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dobro.domain.Message;
import ru.dobro.repos.MessageRepo;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }
    /*
    name="name" -имя
    required=false   -обязательное ли это поле
    defaultValue="World"   -дефолтное значение
    Ниже приведем сокращенную форму.
     */



    @GetMapping   // при входе на localhost мы сразу будем получать результат эту страничку
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);
        return "main";
    }



    @PostMapping   // форма будет отправляться на тот же адрес, с которого пришла сама страничка, поэтому mapping не указываем
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);   // сохранили.

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);   // взяли из репозитория и отдем пользователю.

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

}