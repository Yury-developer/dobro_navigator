package ru.dobro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import javax.sql.DataSource;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import ru.dobro.service.UserService;

//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;



/*
Этот класс при старте приложения конфигурирует rity
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    // Нужен для того, чтобы менеджер мог ходить в базу и искать там пользователей и их роли
//    @Autowired
//    private DataSource dataSource;   // он генерируется спрингом и его можно легко получить

    @Autowired
    private UserService userService;   // делаем это после создания   UserService

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()   // включаем авторизацию
                    .antMatchers("/", "/registration").permitAll()   // для пути "/" (т.е. главная страничка) -разрешаем полный доступ; разрешим страничку   , "/registration"
                    .anyRequest().authenticated()   // для всех остальных запросов мы требуем авторизацию
                .and()
                    .formLogin()   // включаем   formLogin
                    .loginPage("/login")   // логин page находится на таком mapping
                    .permitAll()   // разрешаем этим пользоваться всем
                .and()
                    .logout()   /// включаем   logout
                    .permitAll();   // разрешаем ему пользоваться всем
    }

//    /*
//    UserDetailsService будет выдаваться системе по требованию этим методом.
//    Создает менеджер, который обслуживает учетные записи
//     */
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()   // помечен как depricated. т.к. ничего не шифрует, а при каждом запуске заново создает пользователя
//                        .username("u")   // u - user
//                        .password("l")   // l - password
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }


    // теперь будем брать пользователи из DB
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
//                .jdbcAuthentication()
//                .dataSource(dataSource)   // генерируется Spring. Нужен для того, чтобы Manager мог ходить в DB и искать там пользователей и их роли.
                .passwordEncoder(NoOpPasswordEncoder.getInstance())   // будет шифровать парол, чтобы они не хранилиь у нас в явном виде (NoOpPasswordEncoder только для тестирования, жудко устарел)
//                .usersByUsernameQuery("select username, password, active from usr where username=?")   // этот запрос необходим, чтобы система могла найти пользователя по его имени. Именно в таком порядке. Порядок и набор определены системой.
//                .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?");   // этот запрос помогает спрингу получить список пользователей с их ролями. Поясняю запрос:   из таблицы 'usr' и присоединенной к ней таблицы 'user_role', соединенных через поля 'user_id' и 'id' выбираем поля 'username' и имя роли 'roles'
//                // теперь необходимо добавить страницу регистрации новых пользователей
        ;
    }
}