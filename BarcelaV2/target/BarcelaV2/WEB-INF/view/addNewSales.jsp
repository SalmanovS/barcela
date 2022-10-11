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

</ul>
<link href="<c:url value="/css/navigation.css" />" rel="stylesheet">
<link href="<c:url value="/css/table-style.css" />" rel="stylesheet">
<link href="<c:url value="/css/button.css" />" rel="stylesheet">
<link href="<c:url value="/css/div.css" />" rel="stylesheet">
<link href="<c:url value="/css/reportsTableDiv.css" />" rel="stylesheet">
<link href="<c:url value="/css/reportsTable.css" />" rel="stylesheet">
</head>
<%------------ ����� ������ ��������� ------------%>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

<%------------Корзина ------------%>

   function addSale(){
    var inputBarcode = $(".search").val();

   $.ajax({
        url:'newSale',
        dataType: 'json',
        type: 'get',
        cache: false,
        data: ({barcode: inputBarcode}),
        dataType: "json",
        success: function(data){


            $('.tableStyle').append('<tr class="info"><td><input type="text" size="20" value="'+data.productBarcode+'"readonly class="productBarcode"/> </td><td><input type="text" value="'+data.productName+'"readonly class="productName"/></td><td><input type="text" value="'
            +data.productBrand+'"readonly class="productBrand"/> </td><td><input  type="number" min="1" max="100" value="1" class="productCount" /></td><td><input type="text" class="priceTd" value="'
            +data.productPrice+'" readonly name="productPrice" style="width:80px" /></td><td><input class="total" type="text" value="'+data.productPrice+'" readonly style="width:100px" /></td></tr>');


            $( '.tableStyle' ).on( 'change' , 'input[type="number"]' ,function(){
                var count = $(this ).val();
                var price = $( this ).parents( '.info').find( '.priceTd').val();
                var result = price * count;
                result = Math.round(result * 100) / 100.0;
                $( this ).parents( '.info').find( '.total').val(result);


            });
        }

   });

   }
<%------------Проверка наличия ------------%>


function checkProduct(){
var check = true;

$('.tableStyle > tbody  > tr').each(function() {
var prodBarcode = $(this).find('.productBarcode').val();
var prodCount = $(this).find('.productCount').val();
var prodTotalResult = $(this).find('.total').val();


    $.ajax({
            url:'checkProduct',
            async: false,
            dataType: 'json',
            type: 'get',
            cache: false,
            data: ({prodBarcode: prodBarcode, quantity: prodCount}),
            dataType: "text",
            success: function(res){
               if(res == 'false'){
               trueOrFalse(res)
               }
            }

});

});

function trueOrFalse(res){
    check = false;
alert("There is no specified quantity of goods in stock!");
}

if(check == true){
   saveProduct();
}

}

<%------------Сохранение товара в бд------------%>

function saveProduct(){
    $('.tableStyle > tbody  > tr').each(function() {
    var prodBarcode = $(this).find('.productBarcode').val();
    var prodQuantity = $(this).find('.productCount').val();
    var prodTotal = $(this).find('.total').val();
        $.ajax({
                    url:'saveSales',
                    async: false,
                    dataType: 'json',
                    type: 'get',
                    cache: false,
                    data: ({shtrixCode: prodBarcode, prodQuantity: prodQuantity, prodTotal: prodTotal}),
                    dataType: "text",
                    success: function(data){

                    }

        });

});
 window.location.href = 'addNewSales';
 alert("The sale is completed!");
}
<%------------Сохранение товара в бд(конец)------------%>

function deleteProductsFromTable(){
$(".tableStyle td").remove();
}


</script>
<hr>
<form>
    <input class ="search" type="text"
    placeholder="Enter the barcode"/>
    <input type="button"  class="button" onclick="addSale()"value="Add to cart"/>
    </form>


<hr>

<br>
<div class="product-table">

<table class="tableStyle" align="center">
<tr>
<thead>
    <th> Barcode </th>
    <th> Product name </th>
    <th> Brand </th>
    <th> Quantity </th>
    <th> Price </th>
    <th> Total </th>
</thead>


   </table>

  <div align="right">
  <input type="button" class="button" onclick="checkProduct()" value="Create new sale"/>
  <input type="button" class="button" onclick="deleteProductsFromTable()" value="Delete all products"/>

  </div>
   </div>
<br><br>

<div class="newSalesAllProduct">
   <table class="reportsTable" align="center">
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