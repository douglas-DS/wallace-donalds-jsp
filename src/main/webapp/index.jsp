<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="products" class="com.ds.service.ProductService" scope="session" />
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="global.css">
        <link rel="stylesheet" type="text/css" href="index.css">
        <title>Wallace Donald's</title>
    </head>

    <body>
        <div>
            <form action="order" method="POST">
                <label for="sandwichList">Escholha seu lanche</label>
                <select id="sandwichList" name="sandwichId">
                    <c:forEach items="${products.sandwichList}" var="sandwich">
                        <option value="${sandwich.id}">${sandwich.name} - R$${sandwich.price}</option>
                    </c:forEach>
                </select>

                <hr/>

                <label for="sideDishes">Escholha seu acopanhamento</label>
                <select id="sideDishes" name="sideDishId">
                    <c:forEach items="${products.sideDishes}" var="sideDish">
                        <option value="${sideDish.id}">${sideDish.name} - R$${sideDish.price}</option>
                    </c:forEach>
                </select>

                <hr/>

                <label for="drinks">Escholha sua bebida</label>
                <select id="drinks" name="drinkId">
                    <c:forEach items="${products.drinks}" var="drink">
                        <option value="${drink.id}">${drink.name} - R$${drink.price}</option>
                    </c:forEach>
                </select>

                <hr/>
                <button type="submit">FAZER PEDIDO</button>
            </form>
        </div>

    </body>
</html>