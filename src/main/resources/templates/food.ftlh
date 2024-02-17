<#import "blocks/template.ftlh" as t>
<@t.template>
    <h1>Список еды</h1>
    <hr>
    <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
       data-toggle="collapse" href="#collapseExample" role="button"
       aria-expanded="true" aria-controls="collapseExample">
        Добавить новый товар
    </a>
    <h4>Еда, доступная в меню</h4>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/food/create" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Название товара</label>
                <input type="text" required class="form-control"
                       id="name" name="name">
            </div>
            <div class="form-group">
                <label for="price">Цена товара</label>
                <div class="input-group mb-3">
                    <input type="number" required class="form-control" id="price" name="price">
                    <div class="input-group-append">
                        <span class="input-group-text">₽</span>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="quantity">Количество товара</label>
                <textarea required class="form-control" id="quantity" name="quantity"></textarea>
            </div>
            <div class="form-group">
                <label for="pictureUrl">pictureUrl</label>
                <textarea class="form-control" id="pictureUrl" name="pictureUrl"></textarea>
            </div>
            <div class="form-group">
                <label for="categoryId">Категория</label>
                <select id="categoryId" name="categoryId" class="form-control">
                    <#list categories as category>
                    <option value="1">${category.categoryName}</option>
                    </#list>
                </select>
            </div>
            <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
    </div>
    <#list food as product>
        <div>
            <a href="/food/${product.id}" class="product-link">
                <div class="card text-white bg-dark my-3 product">

                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text">${product.price} ₽</p>
                    </div>
                </div>
            </a>
        </div>
    </#list>
    <hr>
</@t.template>
