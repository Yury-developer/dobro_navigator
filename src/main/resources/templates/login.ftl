<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

    <h2>Login page</h2><br><br><br>

    <@l.login "/login" />
    <a href="/registration">Add new user</a>

</@c.page>