package ru.itis.servlets;
import ru.itis.models.Product;
import ru.itis.models.User;
import ru.itis.services.BasketService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {

    BasketService basketService;

    @Override
    public void init(ServletConfig config){
        ServletContext context = config.getServletContext();
        basketService = (BasketService) context.getAttribute("basketService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        Long userId = null;

        if(user != null) {
            userId = user.getId();
            System.out.println("userId = " + userId);
            List<Product> products = basketService.getForUser(userId);
            for (Product product : products) {
                System.out.println(product.toString());
            }
            req.setAttribute("products", products);
            req.getRequestDispatcher("/WEB-INF/jsp/basket.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("/signIn");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Long userId = null;

        if (user != null){
            if (req.getParameter("id") != null) {
                userId = user.getId();
                Long productId = Long.valueOf(req.getParameter("id"));
                System.out.println(productId);
                System.out.println(userId);
                basketService.save(userId, productId);
                resp.sendRedirect("/products");
            }else{
                resp.sendRedirect("/products");
            }
        }else {
            resp.sendRedirect("/signIn");
        }

    }
}