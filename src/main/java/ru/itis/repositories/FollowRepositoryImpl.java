package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class FollowRepositoryImpl implements FollowRepository {

    JdbcTemplate jdbcTemplate;

    public FollowRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String SQL_ADD_EMAIL = "insert into followers(email) values (?)";

    @Override
    public void addEmail(String email) {
        jdbcTemplate.update(SQL_ADD_EMAIL, email);
    }
}
