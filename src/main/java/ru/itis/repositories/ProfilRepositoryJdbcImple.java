package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Product;
import ru.itis.models.User;

import javax.sql.DataSource;

public class ProfilRepositoryJdbcImple implements ProfilRepository {
    private JdbcTemplate jdbcTemplate;

    public ProfilRepositoryJdbcImple(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private RowMapper<User> profilRowMapper = (row, rowMapper) -> {
        return User.builder()
                .phoneNumber(row.getString("phoneNumber"))
                .email(row.getString("email"))
                .build();
    };
    //language=SQL
    private static final String SQL_FIND_BY_PHONENUMBER = "select phone_number * from user";
    //language=SQL
    private static final String SQL_FIND_BY_EMAIL = "select email * from users";

    @Override
    public void getPhoneNumber(String phoneNumber) {

    }

    @Override
    public void getEmail(String email) {

    }
}
