<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<img src="<c:url value="/images/logo.png" />"/>
<ul class="navigation">
    <li> <a href="/BarcelaV2/">Home page</a></li>
    <li> <a href="/BarcelaV2/sales/index">Sales</a></li>
    <li> <a href="/BarcelaV2/goods/showAllGoods">Goods</a></li>
    <li> <a href="reportsForToday">Reports</a></li>
</ul>
<hr>
<ul  class="downNavigation">
    <li> <a href="reportsForToday">For today</a></li>
    <li> <a href="reportsForWeek">For this week</a></li>
    <li> <a href="reportsForMonth">For this month</a></li>
    <li> <a href="reportsForYear">For this year</a></li>
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
<div class="baseDivReports" >

<div  class = "reportsDiv">
<div class="title-divReportsTable">
Products sold in a year
</div>
<div class="blockWithValues1" >
<table align="center" class="reportsTable">
<tr>
    <th> Barcode </th>
    <th> Product name </th>
    <th> Quantity </th>

    </tr>
    <c:forEach var="showGoods" items="${showGoodsSoldYear}">
            <tr>

                <td >${showGoods.productBarcode}</td>
                <td >${showGoods.productName}</td>
                <td>${showGoods.productCount}</td>

                </tr>
              </c:forEach>

</table>
</div>
</div>
<div  class="reportsDiv">

    <div class="title-divReportsTable">
    Quantity of products sold
    </div>
    <div class="blockWithValues2" >
        ${quantityProductsSoldYear}
    </div>
</div>
<div class ="reportsDiv" >
    <div class="title-divReportsTable">
        Revenue for the year
        </div>
        <div class="blockWithValues2" >
                ${revenueYear}
            </div>
</div>

</div>
</body>
</html>