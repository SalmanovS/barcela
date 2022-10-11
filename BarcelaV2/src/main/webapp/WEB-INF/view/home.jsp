<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <div align="right" class="container">

               <c:url var="logoutUrl" value="/logout"/>
                  <form class="form-inline" action="${logoutUrl}" method="post">
 user <b><c:out value="${pageContext.request.remoteUser}"/></b>  <input type="submit" class="button" value="Log out" />
                     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                   </form>
             </div>
<div class ="logoDiv">
    <div align="left" class = "headInfo">
        <img src="<c:url value="/images/logo.png" />"/>
    </div>
    <div class ="headInfo">
        <div class="title-divReportsTable">
                Sales today
                </div>
                <div class="blockWithValues2" >
                        ${today}
                    </div>

    </div>
    <div class ="headInfo">
        <div class="title-divReportsTable">
            Sales yesterday
        </div>
         <div class="blockWithValues2" >
           ${yesterday}
         </div>

</div>

<ul class="navigation">
    <li> <a href="/BarcelaV2/">Home page</a></li>
    <li> <a href="sales/index">Sales</a></li>
    <li> <a href="goods/showAllGoods">Goods</a></li>
    <li> <a href="reports/reportsForToday">Reports</a></li>
</ul>
<link href="<c:url value="/css/navigation.css" />" rel="stylesheet">
<link href="<c:url value="/css/table.css" />" rel="stylesheet">
<link href="<c:url value="/css/button.css" />" rel="stylesheet">
<link href="<c:url value="/css/reportsTableDiv.css" />" rel="stylesheet">
</head>
<%------------ Конец панели навигации ------------%>
<body
<hr>
<hr>

<h1 class ="welcome">Welcome to myStore</h1>
</body>
</html>

