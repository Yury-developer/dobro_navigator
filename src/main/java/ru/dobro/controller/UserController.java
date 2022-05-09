package ru.dobro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import ru.dobro.beans.Message;
import ru.dobro.beans.Role;
import ru.dobro.beans.User;
import ru.dobro.repos.MessageRepo;
import ru.dobro.repos.UserRepo;

@Controller
@RequestMapping("/user")   // на уровне класса мы пометили mapping для того, чтобы в каждом методе не подписывать, что он содержит в своем пути "/user" (раньше подписывали на уровне методов)
@PreAuthorize("hasAuthority('ADMIN')")   // Эта аннотация будет для каждого из методов данного контроллера перед его выполнением будет проверять наличие у пользователя прав в скобочках (также необходимо будет в 'WebSecurityConfig' добавить аннотацию '@EnableGlobalMethodSecurity(prePostEnabled = true)')
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired // я дописываю, чтобы реализовать метод удаления пользователя
    private MessageRepo messageRepo;


    @GetMapping   // не подписываем mapping, он уже будет содержать в своем пути "/user"
    public String userList(Model model) {   // Теперь нужно припихнуть туда список пользователей в виде модели

        model.addAttribute("users", userRepo.findAll());

        return "userList";
    }

    // Mapping для редактора для пользователя
    @GetMapping("{user}")   // Здесь, для данного метода мы ожидаем mapping помимо "/user" через слэш будет идти идентификатор
    public String userEditForm(@PathVariable User user, Model model) {   // Сразу будем получать пользователя из DB, без дополнительного использования репозитрория
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());   // получаем все значения enum

        return "userEdit";
    }

    // Mapping для сохранения пользователя.
    @PostMapping
    public String userSave(
            @RequestParam String username,   // В форме так-же передается имя пользователя.
            @RequestParam Map<String, String> form,   // Будет приходить из формы каждый раз разное количество полей, поэтому используем Map
            @RequestParam("userId") User user   // По параметру '"userId"' мы будем получать пользователя 'user' из DB (аналогично тому, как это делали в GetMapping
    ) {
        user.setUsername(username);   // установим ему НОВОЕ имя.

        // Прежде, чем обновлять роли пользователю, нам нужно получить список этих ролей, чтобы проверить, что они установлены данному пользователю. Необходимо перевести их из enum в строковый вид.
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        // теперь нужно проверить, что данная форма содержит роли для нашего пользователя.
        for (String key : form.keySet()) {   // Берем форму, получаем список ключей и проверяем по нему. ПОЧЕМУ ТАК? Если в форме присутствует роль, то в интерфейсе для нее установлен флажек.
            if (roles.contains(key)) {   // но помимо ролей в форме присутствуют дополнительные field (токен, id ...) - для этого просто отфильтруем.
                user.getRoles().add(Role.valueOf(key));   // но это сработает лишь в том случае, если у нас роль добавлена. Поэтому см. строку выше 'user.getRoles().clear()' - берем пользователя и очищаем все его роли.
            }
        }

        userRepo.save(user);   // Сохраним в репозиторий новое имя.

        return "redirect:/user";
    }



    // Mapping для удаления для пользователя
    @PostMapping("/remove")
    public String userDelete(
                             @RequestParam Map<String, String> form,   // Будет приходить из формы каждый раз разное количество полей, поэтому используем Map
                             @RequestParam("userId") User user) {

        Iterable<Message> deleteMessage = messageRepo.findByAuthor(user);
        messageRepo.deleteAll(deleteMessage);

        user.getRoles().clear();
        userRepo.delete(user);
        return "redirect:/user";
    }


}
