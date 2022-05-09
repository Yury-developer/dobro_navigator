package ru.dobro.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dobro.beans.User;


public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);   // метод, который будет возвращать пользоватьеля
}
