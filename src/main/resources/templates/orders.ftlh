<#import "blocks/template.ftlh" as t>
<@t.template>
<h1>Заказы</h1><hr>
<#list ordersList as order>
    <div>
        <p><b>Заказ № ${order.id}</b>
            <#list order.orderItems as orderItems>
                <div>
                    ${orderItems.name} ${orderItems.quantity} шт.
                </div>
            </#list>
            ${order.price} руб. </p><hr>
    </div>
</#list>
</@t.template>