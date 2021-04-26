package ru.netology.products_dao.repositories;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.netology.products_dao.models.Order;
import ru.netology.products_dao.models.SQLScriptReader;

import java.util.List;
import java.util.Map;

@Repository
public class ProductsRepositoryJDBC implements ProductsRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String sqlScript;

    public ProductsRepositoryJDBC(NamedParameterJdbcTemplate namedParameterJdbcTemplate, SQLScriptReader sqlScriptReader) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.sqlScript = sqlScriptReader.getSqlScript();
    }

    @Override
    public List<Order> getOrdersByName(String name) {
        return namedParameterJdbcTemplate
                .query(sqlScript, Map.of("name", name), (resultSet, i) -> Order.builder().productName(resultSet.getString("product_name"))
                        .amount(resultSet.getInt("amount")).date(resultSet.getDate("date")).build());

    }
}
