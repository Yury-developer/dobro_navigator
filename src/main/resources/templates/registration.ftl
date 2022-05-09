<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

    <h2>Registration page</h2><br>
    <h3>Add_new_user</h3><br><br><br>

    ${message!}
    <@l.login "/registration" />
    <a href="/main">Main page</a>

</@c.page>