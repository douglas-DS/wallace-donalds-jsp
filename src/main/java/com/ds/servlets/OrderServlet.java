package com.ds.servlets;

import com.ds.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

@WebServlet(name = "servlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var productService = new ProductService();

        var sandwichId = req.getParameter("sandwichId");
        var sandwichQtd = req.getParameter("sandwichQtd");
        var sandwich = productService.findProductById(Integer.parseInt(sandwichId));
        sandwich.setQuantity(new BigDecimal(sandwichQtd));

        var drinkId = req.getParameter("drinkId");
        var drinkQtd = req.getParameter("drinkQtd");
        var drink = productService.findProductById(Integer.parseInt(drinkId));
        drink.setQuantity(new BigDecimal(drinkQtd));

        var sideDishId = req.getParameter("sideDishId");
        var sideDishQtd = req.getParameter("sideDishQtd");
        var sideDish = productService.findProductById(Integer.parseInt(sideDishId));
        sideDish.setQuantity(new BigDecimal(sideDishQtd));

        var products = Arrays.asList(sandwich, sideDish, drink);
        req.setAttribute("products", products);

        req.setAttribute("total", productService.getTotal(products));

        var reqDispatcher = req.getRequestDispatcher("./order.jsp");
        reqDispatcher.forward(req, resp);
    }

}
