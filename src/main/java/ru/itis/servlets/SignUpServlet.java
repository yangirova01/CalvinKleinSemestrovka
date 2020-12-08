package ru.itis.servlets;

import ru.itis.dto.UserForm;
import ru.itis.services.SignUpService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private SignUpService signUpService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.signUpService = (SignUpService) context.getAttribute("signUpService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserForm userForm = UserForm.builder()
                .phoneNumber(req.getParameter("tel"))
                .email(req.getParameter("login"))
                .password(req.getParameter("password"))
                .build();

        String sessionId = req.getSession().getId();

        Cookie cookie = new Cookie("sessionId", sessionId);
        cookie.setMaxAge(60 * 60 * 60);
        resp.addCookie(cookie);

        if (!signUpService.signUp(userForm, sessionId)) {
            req.setAttribute("emailExist", "EMAIL IS EXISTS");
            resp.sendRedirect("/signUp");
        } else
            resp.sendRedirect("/home");
    }
}