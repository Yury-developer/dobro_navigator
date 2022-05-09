<#import "parts/common.ftlh" as c>

<@c.page>
    <h2>User editor</h2><br><br>
    <span><a href="/user">go to   User list</a></span>
    <br><br><br>
    <form action="/user" method="post">
        <#--Отобразим данные, которые хотим отредактировать, а затем этой формочкой передадим их на сервер.-->
        <#--Добавим поле для редактирования имени пользователя-->
        <input type="text" name="username" value="${user.username}">   <#-- и сразу передадим сюда значение, которое уже имеем 'value="${user.username}"'.-->

        <#--нам так-же нужно вывести сюда список ролей-->
        <#list roles as role>   <#--Для отображения списка ролей нужна немного более сложная структура. Для начала итерируемся по списку ролей.-->
            <div>   <#--Каждую роль будем выводить на отдельной строке-->
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>   <#-- '${role}' Название роли пометка: данная роль активна либо неактивна (6:29 минута видео) -->
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>

    <br><br>
    <form action="/user/remove/${user.id}">
        <button type="submit">Delete this user</button>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
    </form>
</@c.page>