package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.dto.SessionDto;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;
    //language=SQL
    private static final String SQL_FIND_BY_EMAIL = "select * from users where email = ?";
    //language=SQL
    private static final String SQL_FIND_ALL = "select * from users";
    //language=SQL
    private static final String SQL_SAVE = "insert into users (phone_number, email, hashpassword, session) values (?, ?, ?, ?)";
    //language=SQL
    private static final String SQL_FIND_SESSION_BY_USER_ID = "select id, session from users where id = ?";
    //language=SQL
    private static final String SQL_ADD_SESSION_TO_USER = "update users set session = ? where id = ?";
    //language=SQL
    private static final String SQL_FIND_SESSION_BY_SESSION_ID = "select id, session from users where session = ?";
    //language=SQL
    private static final String SQL_FIND_USER_BY_ID = "select * from users where id = ?";

    private RowMapper<User> userRowMapper = (row, rowNumber) -> {
        return User.builder()
                .id(row.getLong("id"))
                .phoneNumber(row.getString("phone_number"))
                .email(row.getString("email"))
                .hashPassword(row.getString("hashpassword"))
                .session(row.getString("session"))
                .build();
    };

    private RowMapper<SessionDto> sessionDtoRowMapper = (row, rowMapper) -> {
        return SessionDto.builder()
                .userId(row.getLong("id"))
                .sessionId(row.getString("session"))
                .build();
    };

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, userRowMapper, email));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findUserById(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_USER_BY_ID, userRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<SessionDto> findSessionByUserId(Long userId) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_SESSION_BY_USER_ID, sessionDtoRowMapper, userId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<SessionDto> findSessionBySessionId(String sessionId) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_SESSION_BY_SESSION_ID, sessionDtoRowMapper, sessionId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void addSessionToUser(Long id, String session) {
        //"update account set session = ? where id = ?"
        jdbcTemplate.update(SQL_ADD_SESSION_TO_USER, session, id);
    }

    @Override
    public void save(User entity) {
        //"insert into account (phone_number, email, hash_password, session)
        jdbcTemplate.update(SQL_SAVE,
                entity.getPhoneNumber(),
                entity.getEmail(),
                entity.getHashPassword(),
                entity.getSession());
    }

    @Override
    public void update(User entity) {

    }
    @Override
    public void delete(User entity) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, userRowMapper);
    }
}