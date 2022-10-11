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
<h1 class = "pageError"> A product with such a barcode already exists! </h1>
</body>
</html>