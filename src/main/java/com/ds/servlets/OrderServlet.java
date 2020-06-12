package com.ds.servlets;

import com.ds.pojo.Product;
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
        var sandwich = productService.findProductById(Integer.parseInt(sandwichId));
//        req.setAttribute("sandwich", sandwich);

        var drinkId = req.getParameter("drinkId");
        var drink = productService.findProductById(Integer.parseInt(drinkId));
//        req.setAttribute("drink", drink);

        var sideDishId = req.getParameter("sideDishId");
        var sideDish = productService.findProductById(Integer.parseInt(sideDishId));
//        req.setAttribute("sideDish", sideDish);

        var products = Arrays.asList(sandwich, sideDish, drink);
        req.setAttribute("products", products);

        var total = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        req.setAttribute("total", total);

        var reqDispatcher = req.getRequestDispatcher("./order.jsp");
        reqDispatcher.forward(req, resp);
    }

}
