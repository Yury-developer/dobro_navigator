package ru.dobro.domain;

import javax.persistence.*;


@Entity // это не просто кусок кода, а сущность, которую необходимо будет сохранять в DB
public class Message {
    @Id   // поле   id   будет идентификатором
    @GeneratedValue(strategy = GenerationType.AUTO)   // Spring совместно с DB обязаны разобраться, как будет генерироваться id
    private Integer id;

    private String text;
    private String tag;

    // Указываем, как сохранять   author   в DB
    @ManyToOne(fetch = FetchType.EAGER)   // Указываем DB, что одному пользователю соответствует множество сообщений. Если со стороны пользователя добавлять связь, то юто будет OneToMany
    @JoinColumn(name = "user_id")   // название колонки, как она должна быть записана в DB. Это нужно, чтобы в DB это поле называлось   user_id   а не    author_id (если по умолчанию)
    private User author;   // fetch = FetchType.EAGER   подразумевает, что каждый раз, когда мы получаем сообщение -мы хотим получать информацию об   author   вместе с этим сообщением сразу же.


    /*
    пустой конструктор, чтобы Spring смог создать данный класс.
    т.е. если анотация   @Entity   -то должен быть констр. без параметров.
     */
    public Message() {

    }

    public Message(String text, String tag, User user) {
        this.text = text;
        this.tag = tag;
        this.author = user;
    }


    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
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

    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }

}
