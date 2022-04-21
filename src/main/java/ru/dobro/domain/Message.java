package ru.dobro.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity // это не просто кусок кода, а сущность, которую необходимо будет сохранять в DB
public class Message {
    @Id   // поле   id   будет идентификатором
    @GeneratedValue(strategy = GenerationType.AUTO)   // Spring совместно с DB обязаны разобраться, как будет генерироваться id
    private Integer id;

    private String text;
    private String tag;


    /*
    пустой конструктор, чтобы Spring смог создать данный класс.
    т.е. если анотация   @Entity   -то должен быть констр. без параметров.
     */
    public Message() {

    }

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }

}
