<%@ page import="com.lucas.nolting.models.Cart" %>
<%@ page import="com.lucas.nolting.models.CartImplementation" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lucas.nolting.models.ProductImplementation" %>
<%@ page import="com.lucas.nolting.models.Product" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: lucas
  Date: 9/24/18
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="StyleBuilderClasses.css">
    <title>Cart</title>
</head>
<body>
<div id="header" class="header">
    <div id="nav">

        <a class = "navItemLarge" id="homeName" href="index.jsp">Rocks and Rocks Alone</a>
        <a class="navItem" id="productList" href="productDetail.jsp">Product List</a>
        <a class="navItem" id="cart" href="DisplayCart">Cart</a>
        <a class="navItemSmall" id="goToGitHub"
           href="https://github.com/TheMightyBoops/DistJavaProjectOne">
            View this page's sourcecode</a>
    </div>
</div>

<%
    CartImplementation cartDB = new CartImplementation();
    ProductImplementation prodDB = new ProductImplementation();
    List<Cart> carts = cartDB.getAllCarts();

    if(!carts.isEmpty()) {
        boolean grayInList=false, graniteInList=false, slateInList=false;
        int grayQuan=0, granQuan=0, slateQuan=0;
        double grayPrice=0, granPrice=0, slatePrice=0;
        //total each item
        for (Cart c: carts) {
            if(c.getProductID() == 1) {
                grayQuan = granQuan + c.getQuantity();
                Product grayTemp = prodDB.getProductWithGivenID(c.getProductID());
                grayPrice = grayTemp.getPrice();
                grayInList=true;
            }
            if(c.getProductID() == 2) {
                granQuan = grayQuan + c.getQuantity();
                Product granTemp = prodDB.getProductWithGivenID(c.getProductID());
                granPrice = granTemp.getPrice();
                graniteInList=true;
            }
            if(c.getProductID() == 3) {
                slateQuan = slateQuan + c.getQuantity();
                Product slateTemp = prodDB.getProductWithGivenID(c.getProductID());
                slatePrice = slateTemp.getPrice();
                slateInList=true;
            }
        }

        out.print("<ul>");
        DecimalFormat priceFor = new DecimalFormat("#0.00");
        if(grayInList) {
            out.print("<li><b>Old Gray</b>: " + grayQuan + " $" +
                    priceFor.format(grayPrice * granQuan) + "</li>");
        }

        if(graniteInList) {
            out.print("<li><b>Classic Granite</b>: " + granQuan + " $" +
                    priceFor.format(granPrice * granQuan) +"</li>");
        }

        if(slateInList) {
            out.print("<li><b>Dark Slate</b>: " + slateQuan + " $" +
                    priceFor.format(slatePrice * slateQuan)+"</li>");
        }

        out.print("</ul>");
    } else {
        out.print("Your cart is empty.");
    }
%>
<form action="${pageContext.request.contextPath}/ClearCart" method="post">
    <button class="buttonDefault" name="clearCart" type="submit" value="clearCart">Clear Cart</button>
</form>
</body>
</html>
