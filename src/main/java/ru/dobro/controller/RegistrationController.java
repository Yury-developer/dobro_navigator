package ru.dobro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dobro.domain.Role;
import ru.dobro.domain.User;
import ru.dobro.repos.UserRepo;

import java.util.Collections;
import java.util.Map;


@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;   // делаем это после того, как создали новый репозиторий  'UserRepo'

    @GetMapping("/registration")
    public String registration() {
        return "registration";   // просто будет возвращать view
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        // далее, для того, чтобы найти пользователя нам надо создать новый репозиторий  'UserRepo'
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists! -такой пользователь уже существует!");
            return "registration";   // возвращаем страничку с регистрацией.
        }

        user.setActive(true);   // новый пользователь пусть сразу будет активным.
        user.setRoles(Collections.singleton(Role.USER));   // на вход прилетит коллекция в виде Set, но т.к. у нас всего 1 значение, можно исп. шоткат из стандартной библиотеки, Set с одним единственным значением
        userRepo.save(user);   // сохраняем пользователя

        return "redirect:/login";   // при успешной авторизации перекидываем на страницу логина
    }

}
