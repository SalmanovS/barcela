<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<img src="<c:url value="/images/logo.png" />"/>
<ul class="navigation">
    <li> <a href="#">Sales</a></li>
    <li> <a href="#">Goods</a></li>
    <li> <a href="#">Reports</a></li>
</ul>
<hr>
<ul class="downNavigation">
    <li> <a href="addNewGoods">Add new goods</a></li>
    <li> <a href="#">Add for barcode</a></li>
    <li> <a href="#">Search goods</a></li>
</ul>

</ul>
<link href="<c:url value="/css/navigation.css" />" rel="stylesheet">
<link href="<c:url value="/css/table.css" />" rel="stylesheet">
<link href="<c:url value="/css/button.css" />" rel="stylesheet">
</head>