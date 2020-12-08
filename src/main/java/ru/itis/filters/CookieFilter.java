package ru.itis.filters;
import ru.itis.dto.SessionDto;
import ru.itis.dto.UserDto;
import ru.itis.models.User;
import ru.itis.util.SessionUtil;
import ru.itis.util.UserUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class CookieFilter implements Filter {

    private SessionUtil sessionUtil;
    private UserUtil userUtil;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        sessionUtil = (SessionUtil) context.getAttribute("sessionUtil");
        userUtil = (UserUtil) context.getAttribute("userUtil");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        HttpSession httpSession = request.getSession();

        Boolean isSessionExists = httpSession != null;
        Boolean isAuthenticated = false;
        Boolean isRequestOnOpenPage = request.getRequestURI().equals("/signIn") ||
                request.getRequestURI().equals("/signUp");

        if (isSessionExists)
            isAuthenticated = httpSession.getAttribute("user") != null;

        if (isAuthenticated) {
            Cookie[] cookies = request.getCookies();
            String sessionId = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("sessionId")) {
                        sessionId = cookie.getValue();
                        break;
                    }
                }
            }
            if(sessionId != null) {
                try {
                    SessionDto sessionDto = SessionDto.getFromOptional(sessionUtil.getSessionById(sessionId));
                    if (sessionDto != null) {
                        User user = UserDto.userFromOptional(userUtil.getUserById(sessionDto.getUserId()));
                        httpSession.setAttribute("user", user);
                        httpSession.setAttribute("userId", user.getId());
                        httpSession.setAttribute("email", user.getEmail());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
