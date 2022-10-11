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


<form align="center" action="searchByProductName" method="get">
    <input class ="search" type="text" name="productName"
    placeholder="Search by barcode, product name or brand"/>
    <input type="submit" class ="button" value="Search product"/>
    </form>

    <hr>
<div class="product-table-all">
<div class="title-table">
Results
</div>
    <table align="center" class="tableStyle">
        <tr>
        <th> Barcode </th>
        <th> Product name </th>
        <th>Brand </th>
        <th >Count </th>
        <th>Price</th>
        </tr>

        <c:forEach var="good" items="${productList}">
            <c:url var="updateButton" value="updateGoods">
               <c:param name= "goodproductId" value="${good.productId}"/>
            </c:url>
             <c:url var="deleteButton" value="deleteGoods">
                       <c:param name= "goodproductId" value="${good.productId}"/>
                    </c:url>
            <tr>

                <td >${good.productBarcode}</td>
                <td >${good.productName}</td>
                <td>${good.productBrand}</td>
                <td>${good.productCount}</td>
                <td>${good.productPrice}</td>
                <td><input type="button" class="button" value="Update"
                onClick ="window.location.href = '${updateButton}'"></td>
                <td><input type="button" class="button" value="Delete"
                            onClick ="window.location.href ='${deleteButton}'"></td>
            </tr>
        </c:forEach>
    </table>
    </div>
</body>
</html>