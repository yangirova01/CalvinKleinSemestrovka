<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.11.2020
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profil</title>
    <link rel="stylesheet" href="../../front/css/home.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/search.js"></script>
</head>
<body>
<div class="marquee shrift"><span>Скидки до 50% на осеннюю коллекцию!</span></div>
<div class="main">
    <nav class="navbar navbar-expand-lg navbar-light bg-white ">
        <a class="navbar-brand " href="#">
            <h1>Calvin Klein</h1>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse " id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto ">
                <li class="nav-item active shrift ">
                    <a class="nav-link " href="#">ПРОДУКТЫ</a>
                </li>
            </ul>
            <form>
                <input type="text" class="shrift input" placeholder="ПОИСК"><button type="submit" class="shrift">ИСКАТЬ</button>
            </form>
        </div>
    </nav>
    <div class="category catside">
        <a class="categoryall" href="#">НОВИНКИ</a>
        <a class="categoryall" href="#">НИЖНЕЕ БЕЛЬЕ</a>
        <a class="categoryall" href="#">ОДЕЖДА</a>
        <a class="categoryall" href="#">СУМКИ И АКСЕССУАРЫ</a>
        <a class="categoryall" href="#">ОБУВЬ</a>
        <a class="categoryall" href="#">ПОДАРКИ</a>
        <hr size=3px width=100% align="left">
    </div>
</div>
<footer class="shrift" style="padding-top:300px">
    <hr size=3px width=100% align="left">
    <p style="margin-left: 20px">ПОДПИШИТЕСЬ НА РАССЫЛКУ И ПОЛУЧИТЕ СКИДКУ 10% НА ВАШ ЗАКАЗ</p>
    <p class="dop" style="margin-left: 20px">ОСТАВАЙТЕСЬ В КУРСЕ НАШИХ НОВОСТЕЙ И ПОЛУЧИТЕ СКИДКУ 10%</p>
</footer
</body>
</html>
