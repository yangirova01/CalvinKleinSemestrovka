package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Product;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BasketRepositoryImpl implements BasketRepository {

    private JdbcTemplate jdbcTemplate;

    public BasketRepositoryImpl (DataSource dataSource) {
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
                .image(row.getString("image"))
                .build();
    };
    private static final String SQL_FIND_ALL = "select * from product";
    //language=SQL
    private static final String SQL_SAVE = "insert into basket(userid, productid) values (?, ?)";
    //language=SQL
    private static final String SQL_DELETE_BY_USER_ID = "delete from basket where userId = ?";
    //language=SQL
    private static final String SQL_GET_BY_USER_ID = "select product.id, name, price, type, color, size, product.image from basket join product ON basket.productId = product.id where basket.userId = ?";
    //language=SQL
    private static final String SQL_DELETE_PRODUCT = "DELETE from basket where userId = ? AND productId = ?";

    @Override
    public List<Product> getByUserId(Long userId) {
        return jdbcTemplate.query(SQL_GET_BY_USER_ID, productRowMapper, userId);
    }

    @Override
    public List<Product> findAllCheaperAndType(String price, String type) {
       List<Product> products = jdbcTemplate.query(SQL_FIND_ALL, productRowMapper);
       List<Product> product = new ArrayList<>();
       for (Product product1:products){
           if (Integer.parseInt(product1.getPrice())<=Integer.parseInt(price) && type.equals(product1.getSize())){
               product.add(product1);
           }
       }
       return product;
    }

    @Override
    public void save(Long user, Long product) {
        jdbcTemplate.update(SQL_SAVE, user, product);
    }

    @Override
    public void deleteByUserId(Long userId) {
        jdbcTemplate.update(SQL_DELETE_BY_USER_ID, userId);
    }

    @Override
    public void save(Product entity) {

    }


    public void deleteProductByUserId(Long userId, int id) {
        jdbcTemplate.update(SQL_DELETE_PRODUCT, userId, id);
    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

}
