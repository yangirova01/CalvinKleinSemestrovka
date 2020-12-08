package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Product;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryJdbcImpl implements ProductRepository {

    JdbcTemplate jdbcTemplate;

    public ProductRepositoryJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Product> productRowMapper = (row, rowMapper) -> {
      return Product.builder()
              .id(row.getLong("id"))
              .name(row.getString("name"))
              .color(row.getString("color"))
              .size(row.getString("size"))
              .price(row.getString("price"))
              .type(row.getString("type"))
              .type(row.getString("image"))
              .build();
    };

    //language=SQL
    private static final String SQL_FIND_BY_ID = "select * from product where id = ?";
    //language=SQL
    private static final String SQL_FIND_ALL = "select * from product";


    @Override
    public void save(Product entity) {

    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public Optional findById(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_BY_ID, productRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, productRowMapper);
    }

    @Override
    public Optional<List<Product>> findByType(String type) {
        return Optional.empty();
    }

    @Override
    public Long getId(Product product) {
        return null;
    }
}
