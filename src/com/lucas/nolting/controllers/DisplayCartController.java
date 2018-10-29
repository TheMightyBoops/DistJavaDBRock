package com.lucas.nolting.controllers;

import com.lucas.nolting.models.Cart;
import com.lucas.nolting.models.CartImplementation;
import com.lucas.nolting.models.CartLineItem;
import com.lucas.nolting.models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DisplayCartController extends HttpServlet {
    private final String VIEW_CART = "cart.jsp";
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //CartImplementation cartDB = new CartImplementation();





        //first get all cookies
        /*Cookie[] cookies = request.getCookies();
        String[] names = null, quantities = null;
        String fullNames, fullQuantities;
        Product product = null;
        CartLineItem cartLineItem = null;
        Cart cart = new Cart();

        if(cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("itemName")) {
                    fullNames = c.getValue();
                    names = fullNames.split("\\s*,\\s*");
                } else if (c.getName().equals("quantity")) {
                    fullQuantities = c.getValue();
                    quantities = fullQuantities.split("\\s*,\\s*");
                }

                if (names != null && quantities != null) {
                    for (int i = 0; i < names.length; ++i) {
                        product = new Product(names[i]);
                        cartLineItem = new CartLineItem(
                                product.getName(),
                                product.getPrice(),
                                Integer.parseInt(product.getId()),
                                Integer.parseInt(quantities[i])
                        );

                        cart.addItem(cartLineItem);
                    }
                }
            }
        }*/
        RequestDispatcher view = request.getRequestDispatcher(VIEW_CART);
        view.forward(request, response);
    }
}
