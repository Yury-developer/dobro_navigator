
# navigator
Spring Boot learning


---

[Spring Boot Freemarker: подключаем шаблонизатор Freemarker](https://youtu.be/8MlXahJXLFg)

[Ссылка на git репозиторий из видео](https://github.com/drucoder/sweater/tree/Freemarker)


---

[Для начала необходимо заменить зависимости в pom файле с mustache на Freemarker:](https://gist.github.com/drucoder/e301ed54f19628e3456b85977b0afac1)
[и изменить свойство, отвечающее за помещение _csrf токенов в контекст шаблонизатора,  в фале application.properties:](https://gist.github.com/drucoder/ff6a4179f1982f48cdfa6c48d3be6289)
[Руководство по Freemarker:](https://freemarker.apache.org/docs/dgui.html)
[Страница с описанием директивы list:](https://freemarker.apache.org/docs/ref_directive_list.html)
[Страница с инструкцией по описанию собственных директив:](https://freemarker.apache.org/docs/dgui_misc_userdefdir.html)
[Страница с объяснением по импортам и пространствам имен:](https://freemarker.apache.org/docs/dgui_misc_namespace.html)



---


[гайд на сайте Spring](https://spring.io/guides/gs/securing-web/)

По умолчанию, в Spring Security включен механизм CSRF и нам необходимо передавать со всеми формами ключ защиты. Для этого в файле настроек приложения application.properties нужно добавить строку настройки из блокнота:

[Добавляем СКРЫТЫЕ ПОЛЯ](https://youtu.be/WDlifgLS8iQ&t=4m59s)

[Добавляем ХРАНЕНИЕ пользователя в DB](https://youtu.be/WDlifgLS8iQ&t=6m50s)

[Руководство по mustache](http://mustache.github.io/mustache.5.html)

[Руководство по JPA репозиториям](https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation)

[Настройки БД для Postgres](https://gist.github.com/drucoder/540185d50117491e094991d8a95c772d)

[Зависимость для Postgres](https://gist.github.com/drucoder/17424174aa6c6ae3338632bcedcac859)


Spring Boot Web Application (MVC): Добавляем связь между таблицами БД: при создании сообщений мы указываем автора этого сообщения. Также мы рассматриваем, как можно получить текущего пользователя в контроллере.

Для получения этого результата мы добавляем сервис, реализующий интерфейс UserDetailsService, содержащий только один метод: получение пользователя по его имени. Ровно такой метод уже реализован у нас в репозитории UserRepo, соответственно мы переиспользуем этот репозиторий.

Далее нам необходимо расширить наш класс User интерфейсом UserDetails, т.к. именно его возвращает созданный нами сервис. Также в рамках изменений в логике нашего приложения enum Role должен реализовывать интерфейс GrantedAuthority.

После этого убираем лишние настройки в WebSecurityConfig, заменяя их на нашу реализацию UserDetailsService и модифицируем шаблоны страниц.


---

[Ссылка на плейлист](https://www.youtube.com/watch?v=YCNiWmbnEQ8&list=PLU2ftbIeotGpAYRP9Iv2KLIwK36-o_qYk)

[Ссылка на канал](https://www.youtube.com/channel/UC1g3kT0ZcSXt4_ZyJOshKJQ)

[Ссылка на Яндекс.Дзен](https://zen.yandex.ru/id/5ac20956168a91ffeae449c5)


