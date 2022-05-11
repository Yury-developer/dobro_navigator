<#import "parts/common.ftlh" as c>
<#--для использования шаблонов импортируем его и назначаем ему какой-то алиас-->
<#--при использовании макросов используется '@' в то время, как предопределенная директива использует'#'-->

<@c.page>

        <h2>Greeting page</h2><br><br><br>

        <div>Hello, guest!</div>
        <a href="/main">go to   Main page</a>

</@c.page>
