<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

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

<link href="<c:url value="/css/navigation.css" />" rel="stylesheet">
<link href="<c:url value="/css/table-style.css" />" rel="stylesheet">
<link href="<c:url value="/css/button.css" />" rel="stylesheet">
<link href="<c:url value="/css/div.css" />" rel="stylesheet">
</head>
<%------------ Конец панели навигации ------------%>

</head>
<body>

<hr>
<input type="button" class="button" value="<<Back"
                        onClick ="window.location.href ='http://localhost:8080/BarcelaV2/goods/showAllGoods'">
<hr>
<div class="product-table">
<table align = "center" class="tableStyle">
    <tr>
    <th> Barcode </th>
    <th > Product name</th>
    <th >Brand </th>
    <th >Count </th>
    <th >Price </th>
    </tr>
<form:form action="saveGoods" class="form" modelAttribute="addNewGoods" method="GET">
    <form:hidden path="productId"/>
    <tr>
    <td><form:input path="productBarcode"/></td>
    <td><form:input path="productName"/></td>
     <td><form:input path="productBrand"/></td>
    <td><form:input type="number" min="1" path="productCount"/></td>
    <td><form:input path="productPrice"/></td>
     <td><input type="submit" class="button" value="OK"></td>
    </tr>

        </form:form>
        </table>
        </div>
</body>
</html>