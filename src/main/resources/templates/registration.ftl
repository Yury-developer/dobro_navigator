<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

    <h2>Add_new_user</h2><br><br><br>

    ${message!" " }
        <@l.login "/registration" />

</@c.page>