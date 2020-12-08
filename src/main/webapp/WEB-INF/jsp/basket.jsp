<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 20.11.2020
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Basket</title>
    <link rel="stylesheet" href="../front/css/home.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:ital,wght@0,300;1,400&display=swap" rel="stylesheet">
<%--    <script>--%>
<%--        function rendering(products, container){--%>
<%--            let innerHTML = '<div class=\"row\">';--%>
<%--            console.log(innerHTML);--%>
<%--            for (let i = 0; i < products.length; i++) {--%>
<%--                innerHTML += '<hr size="100%">';--%>
<%--                innerHTML += '<div class=\"products\">';--%>
<%--                innerHTML += '<h2 id=\"products-name\" class="shrift" style="font-size: 20px">'+ products[i]['name']+'</h2>';--%>
<%--                innerHTML += '<img src=\"/img?filename='+ products[i]['image'] + '\">';--%>
<%--                innerHTML += '<p id=\"products-color\" class="shrift">'+'ЦВЕТ: '+ products[i]['color']+'</p>';--%>
<%--                innerHTML += '<p id=\"products-price\" class="shrift">'+'ЦЕНА: '+ products[i]['price']+'</p>';--%>
<%--                innerHTML += '<p id=\"products-size\" class="shrift">'+'РАЗМЕР:'+ products[i]['size']+'</p>';--%>
<%--                innerHTML += '<form action="/products? id=${product.id}" method="post"><button type="submit" class="test mybtn" id="btnBuy">В КОРЗИНУ</button></form>';--%>
<%--                console.log(innerHTML);--%>
<%--            }--%>
<%--            innerHTML += '</div>';--%>
<%--            container.html(innerHTML);--%>
<%--        }--%>
<%--        function showProducts() {--%>
<%--            let data = {--%>
<%--                "price" : $('#price').val(),--%>
<%--                "type" : $('#type').val()[0]--%>
<%--            };--%>
<%--            console.log($('#price').val());--%>
<%--            console.log($('#type').val()[0]);--%>
<%--            $.ajax({--%>
<%--                type: "POST",--%>
<%--                url: "/products",--%>
<%--                data: JSON.stringify(data),--%>
<%--                success: function (response){--%>
<%--                    rendering(response, $('#products'))--%>
<%--                },--%>
<%--                dataType: "json",--%>
<%--                contentType: "application/json",--%>
<%--                encoding: "UTF-8"--%>
<%--            });--%>
<%--        }--%>
<%--    </script>--%>
</head>
<body>
<form action="/basket" method="post">
    <div class="marquee shrift"><span>Скидки до 50% на осеннюю коллекцию!</span></div>
    <div class="main">
        <nav class="navbar navbar-expand-lg navbar-light bg-white ">
            <a class="navbar-brand " href="#">
                <h1>Calvin Klein</h1>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto ">
                    <li class="nav-item active shrift ">
                        <form action="/products" method="post">
                            <a class="nav-link " href="/products">ПРОДУКТЫ</a>
                        </form>
                    </li>
                </ul>
            </div>

            <form>
                <input type="text" class="shrift input" placeholder="ПОИСК">
                <button type="submit" class="shrift">ИСКАТЬ</button>
            </form>
            <form action="/signUp" method="get">
                <button type="submit" class="shrift signUp" style="color: black" data-toggle="modal"
                        data-target="#exampleModalSignUp" href="/signUp">ЗАРЕГИСТРИРОВАТЬСЯ
                </button>
            </form>
            <form action="/signIn" method="get">
                <button type="submit" class="shrift signIn" style="color: black" data-toggle="modal"
                        data-target="#exampleModal" href="/signIn">ВОЙТИ
                </button>
            </form>
            <form action="/basket" method="get">
                <button class="logo" style="background-color:white">
                    <svg width="2em" height="2em" viewBox="0 0 20 20" fill="black" xmlns="http://www.w3.org/2000/svg"
                         href="/basket">
                        <path fill-rule="evenodd"
                              d="M8 1a2.5 2.5 0 0 0-2.5 2.5V4h5v-.5A2.5 2.5 0 0 0 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5v9a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V5H2z"/>
                    </svg>
                </button>
            </form>
            <form action="/profil" method="post">
                <button style="background-color:white">
                    <svg width="2em" height="2em" viewBox="0 0 18 18" fill="black" xmlns="http://www.w3.org/2000/svg"
                         href="/profil">
                        <path fill-rule="evenodd"
                              d="M10 5a2 2 0 1 1-4 0 2 2 0 0 1 4 0zM8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6 5c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
                    </svg>
                </button>
            </form>
        </nav>
</div>
<hr>
<div class="shrift">
    <h2 style="margin-left: 50px">ВАША КОРЗИНА</h2>
    <center>
    <div style="padding-bottom: 200px">
        <c:forEach items="${products}" var="product">
            <hr>
            <div class="products">
                <h2 id="products-name">${product.name}</h2>
                <p id="products-price" style="max-width: 380px">${product.price}</p>
                <p id="products-type" style="max-width: 380px">${product.type}</p>
                <img src="/img?filename=${product.image}">
                <form action="/deleteFromBasket?id=${product.id}" method="post"><button class="test mybtn">УДАЛИТЬ ИЗ КОРЗИНЫ</button> </form>
            </div>
        </c:forEach>
    </div>
    </center>
    <hr>
    <p style="margin-left: 50px">Стандартная доставка: 399,00 руб.</p>
    <div>
        <hr>
        <div class="payment">
            <p style="margin-left:40px">СПОСОБЫ ОПЛАТЫ:</p></div>
        <form action="/end?bought=yes" method="post" href="/end">
            <div class="payment"> <a class="categoryall" href="/end">ОПЛАТА НАЛИЧНЫМИ</a></div></form>
        <form action="/end" method="post">
            <div class="payment"> <a class="categoryall" href="/end">ОПЛАТА БАНКОВСКОЙ КАРТОЙ</a></div></form>
    </div>
</div>
<footer class="shrift"style="padding-top: 100px">
    <hr>
    <p style="margin-left: 50px">ПОДПИШИТЕСЬ НА РАССЫЛКУ И ПОЛУЧИТЕ СКИДКУ 10% НА ВАШ ЗАКАЗ</p>
    <p class="dop" style="margin-left: 50px">ОСТАВАЙТЕСЬ В КУРСЕ НАШИХ НОВОСТЕЙ И ПОЛУЧИТЕ СКИДКУ 10%</p>
    <form>
        <div class="form-inline">
            <input type="text" style="margin-left: 50px" class="gdg"placeholder="ВВЕДИТЕ ЭЛ.АДРЕС">
            <button class="test mybtn">ПОДПИШИТЕСЬ</button>
        </div>
    </form>
</footer>

</div>
</form>
</body>
</html>
