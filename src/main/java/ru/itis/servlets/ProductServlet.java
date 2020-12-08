package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.models.Product;
import ru.itis.models.User;
import ru.itis.services.BasketService;
import ru.itis.util.ProductsUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    ProductsUtil productsUtil;
    BasketService basketService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        productsUtil = (ProductsUtil) context.getAttribute("productsUtil");
        basketService = (BasketService) context.getAttribute("basketService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        List<Product> products = productsUtil.getAllProducts();
//        req.setAttribute("productForJSP", products);

        req.getRequestDispatcher("/WEB-INF/jsp/products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Product product = objectMapper.readValue(req.getReader(), Product.class);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        List<Product> products = basketService.findAllCheaperAndType(product.getPrice(), product.getType());

        resp.getWriter().println(objectMapper.writeValueAsString(products));
    }
}
