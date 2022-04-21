package ru.dobro.repos;

import ru.dobro.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


// Базовый репозиторий, позволяет получить полный список полей, либо найти их по id
public interface MessageRepo extends CrudRepository<Message, Long> {

    // для поиска в 'DB' по тэгу
    List<Message> findByTag(String tag);

}