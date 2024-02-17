<#import "blocks/template.ftlh" as t>
<@t.template>
<h1>Список еды</h1><hr>

<h4>Подробная информация о продукте</h4>
<b>Название товара: </b>${product.name}<br>
<b>Количество товара: </b>${product.quantity}<br>
<b>Цена товара: </b>${product.price}<br>
<b>Ссылка на изображение: </b>${product.pictureUrl?if_exists}<br>
<b>Категория товара: </b>${product.categoryEntity.categoryName?if_exists}<br>
<hr>
<form action="/food/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар"/>
</form>
</@t.template>