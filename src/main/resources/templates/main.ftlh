<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>

        <h2>Main page</h2><br><br><br>

    <div>
        <@l.logout />
        <#--Вставим макрос разлогинивания-->

        <br><br>
        <span><a href="/user">User list</a></span>
        <br><br><br>
    </div>

    <div>
        <form method="post">
            <input type="text" name="text" placeholder="Введите сообщение" />
            <input type="text" name="tag" placeholder="Тэг">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <br>
            <button type="submit">Добавить</button>
            <br>
        </form>
    </div>

    <br>
    <div>Список сообщений по указанному ниже тэгу:</div>

    <form method="get" action="/main">
        <input type="text" name="filter" value="${filter!}">   <#--Добавим значение 'value="${filter}"', которое удем выплевывать в страничку -->
        <button type="submit">Найти</button>
        <#--csrf токен (value="${_csrf.token}") отсюда убираем, т.к. он нужен только для pos - запросов. Здесь он нам не нужен.-->
    </form>

    <br>
    <!-- отобразим список сообщений-->
    <#--Синтаксис обхода списка во 'freemarker' выглядит так:-->
    <#--'list messages' - это коллекция, которую мы обходим, 'message' - элиас для одного экземпляра-->
    <#list messages as message>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tag}</i>
            <strong>${message.authorName}</strong>
        </div>
        <#else>   <#--Будет выводиться, если у нас коллекция пустая.-->
        No message
    </#list>

</@c.page>