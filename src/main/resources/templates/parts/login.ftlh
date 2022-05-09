<#macro login path>
<!--определяем новый макрос, который называется "login" будет иметь переменную "path" аргумент-->
    <form action="${path}" method="post">
    <!--используем нашу переменную, которую определили выше-->

        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>

        <!--добавляем скрытое поле. Это поле нужно вставить во все файлы мусташ для каждой формы, т.к. любой запрос, кот. не будет сопровождаться этим токеном будет сервером ИГНОРИРОВАТЬСЯ.-->
        <input type="hidden" name="_csrf" value="${_csrf.token}" />   <#--токен будет целиком в контексте-->

        <br>
        <div><input type="submit" value="Sign In"/></div>
        <br>

    </form>
</#macro>



<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Sign Out"/>
    </form>
</#macro>