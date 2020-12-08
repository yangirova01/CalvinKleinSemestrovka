package ru.itis.servlets;

import ru.itis.dto.UserDto;
import ru.itis.dto.UserForm;
import ru.itis.models.User;
import ru.itis.services.SignInService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    SignInService signInService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.signInService = (SignInService) context.getAttribute("signInService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserForm userForm = UserForm.builder()
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .build();

        User user = signInService.signIn(userForm);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/home");
        } else {
            resp.sendRedirect("/signIn");
        }
//        HttpSession httpSession = req.getSession(true);
//        httpSession.setAttribute("authenticated", true);
//        httpSession.setAttribute("email", userForm.getEmail());
    }
}

