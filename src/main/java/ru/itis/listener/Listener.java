package ru.itis.listener;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.repositories.*;
import ru.itis.services.*;
import ru.itis.util.ProductsUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext servletContext = servletContextEvent.getServletContext();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/calvinklein");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");

        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        ProductRepository productRepository = new ProductRepositoryJdbcImpl(dataSource);
        BasketRepository basketRepository = new BasketRepositoryImpl(dataSource);
        FollowRepository followRepository = new FollowRepositoryImpl(dataSource);

        ProductsUtil productsUtil = new ProductsUtil(productRepository);
        SignUpService signUpService = new SignUpServiceImpl(usersRepository, passwordEncoder);
        SignInService signInService = new SignInServiceImpl(usersRepository, passwordEncoder);
        BasketService basketService = new BasketServiceImpl(basketRepository);
        FollowService followService = new FollowServiceImpl(followRepository);

        servletContext.setAttribute("signUpService", signUpService);
        servletContext.setAttribute("signInService", signInService);
        servletContext.setAttribute("productsUtil", productsUtil);
        servletContext.setAttribute("basketService", basketService);
        servletContext.setAttribute("followService", followService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
