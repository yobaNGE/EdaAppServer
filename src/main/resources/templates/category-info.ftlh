<#import "blocks/template.ftlh" as t>
<@t.template>
<h1>Список категорий</h1><hr>
<#--<h4>Подробная информация о продукте</h4>-->
<b>Название категории:</b>${category.categoryName}<br>
<b>Товары в категории:</b><br>
<#list products as product>
    <div>
        <p><b>${product.name}</b> | <a href="/food/${product.id}">Подробнее...</a></p>
    </div>
</#list>
</@t.template>