<#import "blocks/template.ftlh" as t>
<@t.template>
<h1>Список категорий еды</h1><hr>
<#list categories as category>
    <div>
        <p><b>${category.categoryName}</b> | <a href="/categories/${category.id}">Подробнее...</a></p>
    </div>
</#list>
<hr>
<h3>Добавить категорию</h3>
<form action="/categories/create" method="post" enctype="multipart/form-data">
    Category: <input type="text" name="category"/><br><br>
    Отображаемое название категории: <input type="text" name="categoryName"/><br><br>
    <input type="submit" value="Добавить категорию"/>
</form>
</@t.template>