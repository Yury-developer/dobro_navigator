package ru.dobro.repos;

import ru.dobro.beans.Message;
import org.springframework.data.repository.CrudRepository;
import ru.dobro.beans.User;

import java.util.List;


// Базовый репозиторий, позволяет получить полный список полей, либо найти их по id
public interface MessageRepo extends CrudRepository<Message, Long> {

    // для поиска в 'DB' по тэгу
    List<Message> findByTag(String tag);

    List<Message> findByAuthor(User user); // это моё художество

}