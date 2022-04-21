package ru.dobro.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dobro.domain.User;


public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);   // метод, который будет возвращать пользоватьеля
}
