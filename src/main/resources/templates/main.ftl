<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout />
        <#--Вставим макрос разлогинивания-->
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

    <br><br><br>
    <div>Список сообщений</div>

    <form method="get" action="/main">
        <input type="text" name="filter" value=${filter!}>   <#--Добавим значение 'value="${filter}"', которое удем выплевывать в страничку -->
        <button type="submit">Найти</button>
        <#--csrf токен (value="${_csrf.token}") отсюда убираем, т.к. он нужен только для pos - запросов. Здесь он нам не нужен.-->
    </form>

    <br><br><br>
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