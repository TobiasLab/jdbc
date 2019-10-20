package no.kristiania.jdbc;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WebshopTest {
    @Test
    void shouldRetrieveStoredProduct() throws SQLException {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:mem:test");

        dataSource.getConnection().createStatement().executeUpdate(
                "create table products (name varchar(100))"
        );
    }

    private String pickOne(String[] strings) {
        return strings[new Random().nextInt(strings.length)];
    }

}
