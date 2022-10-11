<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<img src="<c:url value="/images/logo.png" />"/>
<ul class="navigation">
    <li> <a href="/BarcelaV2/">Home page</a></li>
    <li> <a href="index">Sales</a></li>
    <li> <a href="/BarcelaV2/goods/showAllGoods">Goods</a></li>
    <li> <a href="/BarcelaV2/reports/reportsForToday">Reports</a></li>
</ul>
<hr>
<ul  class="downNavigation">
        <li> <a href="addNewSales">New sales</a></li>
        <li> <a href="searchSales">Search sales</a></li>
</ul>
<hr>

</ul>
<link href="<c:url value="/css/navigation.css" />" rel="stylesheet">
<link href="<c:url value="/css/reportsTable.css" />" rel="stylesheet">
<link href="<c:url value="/css/button.css" />" rel="stylesheet">
<link href="<c:url value="/css/reportsTableDiv.css" />" rel="stylesheet">
</head>
<%------------ ????? ?????? ????????? ------------%>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">


</script>
<div align="center" class="orderInfoTable" >
<table align="center" class="reportsTable">
<tr>
    <th> Barcode </th>
    <th> Product name </th>
    <th> Brand </th>
    <th> Quantity </th>
    <th> Price </th>
    <th> Total </th>
    <th> Operations </th>



    </tr>
    <c:forEach var="showGoods" items="${salesList}">
        <c:url var="removeProduct" value="deleteProductFromSales">
            <c:param name= "idSales" value="${showGoods.idSales}"/>
                </c:url>

            <tr>

                <td >${showGoods.productBarcode}</td>
                <td >${showGoods.productName}</td>
                <td >${showGoods.productBrand}</td>
                <td >${showGoods.productCount}</td>
                <td >${showGoods.productPrice}</td>
                <td >${showGoods.totalPrice}</td>
                <td ><input type="button" class="button" value="Delete product"
                                onClick ="window.location.href = '${removeProduct}'"></td>
                </tr>
              </c:forEach>

</table>
</div>
</body>
</html>