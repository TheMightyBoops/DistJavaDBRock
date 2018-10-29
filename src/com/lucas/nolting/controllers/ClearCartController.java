package com.lucas.nolting.controllers;

import com.lucas.nolting.models.Cart;
import com.lucas.nolting.models.CartImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ClearCartController  extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
         final String CART_PATH = "/cart.jsp";

         response.setContentType("text/html");
        RequestDispatcher view = request.getRequestDispatcher(CART_PATH);
        CartImplementation cartDB = new CartImplementation();
        List<Cart> carts = cartDB.getAllCarts();
        for(Cart c: carts) {
            cartDB.deleteCart(c);
        }
        view.forward(request, response);

    }
}
