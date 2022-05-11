<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>print All Shops</title>
    </head>

    <body>
        <table          <#-- Тэги таблицы:   http://htmlbook.ru/html/type/table  -->
                cellspacing="2"   <#-- Расстояние между ячейками. -->
                border="1"   <#-- Толщина рамки в пикселах. -->
                bordercolor="#c0c0c0"   <#-- Цвет рамки. -->
                cellpadding="5"   <#-- Отступ от рамки до содержимого ячейки. -->
                width="800"   <#-- Ширина таблицы. -->
                summary="Общая информация по открытым магазинам ДОБРОЦЕН на территории РБ"   <#-- Краткое описание таблицы.. -->
        >
            <caption>Информация по магазинам:</caption>   <#-- Название таблицы -->

            <tbody>
                <tr style="background: #e4e5cf">
                    <th>№</th>   <#-- Shop Number -->
                    <th>Область</th>   <#-- Shop Region -->
                    <th>Адрес</th>   <#-- Shop Adress -->
                    <th>Широта</th>   <#-- Shop latitude -->
                    <th>Долгота</th>   <#-- Shop longitude -->
                </tr>

                <#list shops as shop>
                <tr style="background: #fafafa">
                    <td>${shop.number}</td>
                    <td>${shop.shopAddressLocation.region}</td>
                    <td>${shop.shopAddressLocation.address}</td>
                    <td>${shop.shopAddressLocation.latitude}</td>
                    <td>${shop.shopAddressLocation.longitude}</td>
                </tr>
                </#list>
            </tbody>

        </table>

        <br><br>
        <a href="/main">go to   Main page</a>
    </body>
</html>