<#import "parts/common.ftlh" as c>

<@c.page>
    <h2>User List page</h2><br><br>
    <span><a href="/main">go to   Main page</a></span>
    <br><br>
    <span><a href="/registration">Add new user</a</span><br><br>

    <h3>List of users:</h3>

    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Role</th>
                <th></th>
            </tr>
        </thead>

        <tbody>
            <#list users as user>
                <tr>
                    <td>${user.username}</td>
                    <td><#list user.roles as role>${role}<#sep>, </#list></td>   <#--Ролей у User может быть несколько, соответственно выводить их будем в виде списка.-->

                    <#-- Во FreeMarker есть сепаратор '<#sep>', который позволяет разделить выводимые элементы (роли в данном случае) запятой.
                        Он указывает, что все элементы из списка '#list user.roles' будут разделяться сочетанием ', '.
                        Этот разделитель будет выводиться только между элементами (без сепаратора все роли вывелись бы единой строкой.)-->

                    <td><a href="/user/${user.id}">edit</a></td>   <#--Ссылка на страничку с редактированием.-->
                </tr>
            </#list>
        </tbody>

    </table>
</@c.page>