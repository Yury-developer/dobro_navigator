<#macro page>
<!-- '#macro page' - заголовок // 'page' - название // '' - параметр (тут опустим) -->
<!--добавим сюда секцию, котора будет принимать в себя вложенный код-->


    <!DOCTYPE html>
    <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Navigator project</title>
        </head>

        <#--Добавим сюда секцию, которая будет принимать в себя вложенный код, для этого используется спец. макрос '<#nested>'-->
        <body>
            <#nested>
        </body>

    </html>

</#macro>