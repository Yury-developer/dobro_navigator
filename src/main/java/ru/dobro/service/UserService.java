package ru.dobro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.dobro.repos.UserRepo;


@Service   // просто даем спрингу знать, что это сервис. Магий тут нет никаких.
public class UserService implements UserDetailsService {



    // но так делать уже не модно, а модно так как ниже/ Но для целей обучения пока сделаем через   Autowired
    @Autowired
    private UserRepo userRepo;

//    // А модно так: Spring когда ицициализирует компонент или Bean - он видит, что у нас в конструкторе есть какие-то зависимости и пытается сразу их заинжектить
//    public UserService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

}

