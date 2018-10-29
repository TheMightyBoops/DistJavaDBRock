package com.lucas.nolting.controllers;

import com.lucas.nolting.models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import static com.lucas.nolting.models.Image.GRANITE;
import static com.lucas.nolting.models.Image.OLD_GRAY;
import static com.lucas.nolting.models.Image.SLATE;


/**
 * This controller populates a list of all of the products
 *
 * @author Lucas Nolting
 * @version 1.0
 * */
public class ProductController extends HttpServlet{
    // constants
    private static final String PRODUCT_LIST = "/productListing.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NameController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NameController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    public void doGet(HttpServletRequest rq,
                      HttpServletResponse res)
            throws ServletException, IOException{
        /*try {

        } catch (ServletException se) {
            System.out.println(se.getMessage());

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }*/
    }

    @Override
    public void doPost(HttpServletRequest rq, HttpServletResponse res)
            throws ServletException, IOException{






        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        //get which item was submitted
        Enumeration paraNames = rq.getParameterNames();
        String name = (String) paraNames.nextElement();

        RequestDispatcher view = rq.getRequestDispatcher(PRODUCT_LIST);


        Product product;

        out.println("Test");
        if(name.trim().equalsIgnoreCase("oldgray")) {
            product = new Product("Old Gray");
        } else if (name.trim().equalsIgnoreCase("granite")) {
            product = new Product("Classic Granite");
        } else if (name.trim().equalsIgnoreCase("slate")) {
            product = new Product("Dark Slate");
        } else {
            product = new Product(null);
        }
        rq.setAttribute("product", product);
        view.forward(rq, res);
    }


}
