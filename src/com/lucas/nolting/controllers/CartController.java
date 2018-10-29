package com.lucas.nolting.controllers;

import com.lucas.nolting.models.Cart;
import com.lucas.nolting.models.CartImplementation;
import com.lucas.nolting.models.CartLineItem;
import com.lucas.nolting.models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;



public class CartController extends HttpServlet {
    private static final String  HOME_PATH = "/index.jsp";

    public void doPost(HttpServletRequest rq, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        RequestDispatcher view = rq.getRequestDispatcher(HOME_PATH);

        String[] productId = rq.getParameterValues("addToCart");
        String[] quantity = rq.getParameterValues("quantity");


        CartImplementation cartDB = new CartImplementation();
        Cart cartToAdd = new Cart(Integer.parseInt(quantity[0]),Integer.parseInt(productId[0]));
        cartDB.addCart(cartToAdd);
        /*Cookie[] itemCookies = rq.getCookies();
        Cookie setName = null;
        Cookie setQuan = null;

        if(itemCookies != null) {
            boolean cookiesExist = false;
            for(Cookie c: itemCookies) {
                if(c.getName().equals("itemName")) {
                    cookiesExist = true;
                    setName = c;
                } else if(c.getName().equals("quantity")) {
                    setQuan = c;
                }
            }

            if(!cookiesExist) {
                setName = new Cookie("itemName", productName[0]);
                setQuan = new Cookie("quantity", quantity[0]);
                setName.setMaxAge(60*60*24);
                res.addCookie( setName );

                setQuan.setMaxAge(60*60*24);
                res.addCookie( setQuan );
            } else {
                String tempName = setName.getValue();
                setName.setValue(tempName + "," + productName[0]);
                String tempQuantity = setQuan.getValue();
                setQuan.setValue(tempQuantity + "," + quantity[0]);
                res.addCookie(setName);
                res.addCookie(setQuan);
            }*/
        view.forward(rq, res);

    }
}
