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

<div class="baseDivReports">



    <div class="reportsDiv">
    <div class="title-divReportsTable">
    Sales today
    </div>
            <div class="blockWithValues1" >
            <table align="center" class="reportsTable">
                <tr>
                    <th> Order </th>
                    <th>Info</th>

        </tr>
        <c:forEach var="showSale" items="${showTodaySales}">
        <c:url var="orderInfoButton" value="orderInfo">
                   <c:param name= "orderSales" value="${showSale}"/>
                </c:url>
                <tr>

                    <td ><b>${showSale}</b></td>
                    <td ><input type="button" class="button" value="Go to order"
                    onClick ="window.location.href = '${orderInfoButton}'"></td>

                    </tr>
                  </c:forEach>

            </table>
            </div>
        </div>


    <div class="reportsDiv">
    <div class="title-divReportsTable">
    All sales
    </div>
        <div class="blockWithValues1" >
        <table align="center" class="reportsTable">
            <tr>
                <th> Order </th>
                <th>Info</th>

    </tr>
    <c:forEach var="showGoods" items="${showAllSales}">
    <c:url var="orderInfoButton" value="orderInfo">
               <c:param name= "orderSales" value="${showGoods}"/>
            </c:url>
            <tr>

                <td ><b>${showGoods}</b></td>
                <td ><input type="button" class="button" value="Go to order"
                onClick ="window.location.href = '${orderInfoButton}'"></td>





                </tr>
              </c:forEach>

        </table>
        </div>
    </div>


</div>
</body>
</html>