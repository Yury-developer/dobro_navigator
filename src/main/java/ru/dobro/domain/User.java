package ru.dobro.domain;

import javax.persistence.*;
import java.util.Set;


@Entity   // это сущность
@Table(name = "usr")   // храниться он будет в табличке. Почему не   user? Postgres не любит таблички, кот. совпадают с ключевыми словами. у НЕГО ТАКАЯ ТАБЛИЧКА   USER  УЖЕ ЕСТЬ, И ОНА УЖЕ ЗАНЯТА.
public class User {

    @Id   // сам разберется с генерацией   id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;

    // у пользователей будет ролевая система, т.е. админ и превелигированный.
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    // fetch определяет, как данные значения будут подгружаться относительно основной сущности. ЖАДНЫЙ - это Hibernate при запросе пользователя будет подгружать все его роли. ЛЕНИВЫЙ - он подгрузит роли только когла пользователь обратится к этомку полю.
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    // данное поле будет храниться в отдельной таблице,  для которой мы не описывали mapping. это позволяет нам создать табличку для   user_role   набора ролей, кот. будет соединяться с текущей табл. через   user_id
    @Enumerated(EnumType.STRING)   // Этот Enum мы хотим хранить в виде строки.
    private Set<Role> roles;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}