<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<img src="<c:url value="/images/logo.png" />"/>
<ul class="navigation">
    <li> <a href="/BarcelaV2/">Home page</a></li>
    <li> <a href="/BarcelaV2/sales/index">Sales</a></li>
    <li> <a href="showAllGoods">Goods</a></li>
    <li> <a href="/BarcelaV2/reports/reportsForToday">Reports</a></li>
</ul>
<hr>
<ul  class="downNavigation">
    <li> <a href="addNewGoods">Add new goods</a></li>
    <li> <a href="addNewGoodsByBarcode">Add goods by barcode</a></li>
    <li> <a href="searchProducts">Search goods</a></li>
</ul>

</ul>
<link href="<c:url value="/css/navigation.css" />" rel="stylesheet">
<link href="<c:url value="/css/table-style.css" />" rel="stylesheet">
<link href="<c:url value="/css/button.css" />" rel="stylesheet">
<link href="<c:url value="/css/div.css" />" rel="stylesheet">
</head>
<%------------ Конец панели навигации ------------%>

<body>
<hr>


<div class="product-table">
<form align="center" action="addGoodsByBarcode" method="get">
    <input type="text" name="enteredBarcode"
    placeholder="Enter barcode"/>
    <input type="submit" value="Barcode"/>
    </form>
    <br>
<table class="tableStyle" align="center">
    <tr>
    <th> Barcode </th>
    <th> Product name </th>
    <th>Brand </th>
    <th >Count </th>
    <th>Price</th>
    <th> Add / reduce</th>
    </tr>

        <tr>
        <form action="saveGoodsByBarcode" method="get">
            <td ><input class="input-table" value="${byBarcode.productBarcode}" readonly name="productBarcode"/></td>
            <td >${byBarcode.productName}</td>
            <td>${byBarcode.productBrand}</td>
            <td>${byBarcode.productCount}</td>
            <td>${byBarcode.productPrice}</td>
            <td><input class="input-table" type="number" value="0" name="countForAddByBarcode"
            placeholder="Positive or negative"/></td>
            <td> <input type="submit" value="Add"/>

        </tr>
</table>
<br>

<div class="title-table">
Results
</div>
<hr>
<table class="tableStyle" align="center">
    <tr>
    <th> Barcode </th>
    <th> Product name </th>
    <th>Brand </th>
    <th >Count </th>
    <th>Price</th>
    </tr>
            <tr>

            <td >${showGoodsByBarcode.productBarcode}</td>
            <td >${showGoodsByBarcode.productName}</td>
            <td>${showGoodsByBarcode.productBrand}</td>
            <td>${showGoodsByBarcode.productCount}</td>
            <td>${showGoodsByBarcode.productPrice}</td>
        </tr>
</table>
</div>
<hr>
<div class="title-table">
All products list
</div>
<div class="product-table-all">
<table class="tableStyle" align="center">
    <tr>
    <th> Barcode </th>
    <th> Product name </th>
    <th>Brand </th>
    <th >Count </th>
    <th>Price</th>
    </tr>

    <c:forEach var="good" items="${allGoods}">

        <tr>

            <td >${good.productBarcode}</td>
            <td >${good.productName}</td>
            <td>${good.productBrand}</td>
            <td>${good.productCount}</td>
            <td>${good.productPrice}</td>

        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>