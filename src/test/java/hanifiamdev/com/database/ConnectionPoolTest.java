package hanifiamdev.com.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

    @Test
    void testHikariCp() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_database?serverTimezone=Asia/Jakarta");
        config.setUsername("root");
        config.setPassword("+5199_MgK");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60_000);

        // Membuat Connection Pool
        HikariDataSource dataSource = new HikariDataSource(config);

        try {
            Connection connection = dataSource.getConnection();
            connection.close(); // ini hanya mengembalikan koneksi ke pool aja  buka nutup koneksi
            dataSource.close();
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }

    }

    // mengggunkan yang dari ConnectionUtil agar mudah kedepannya untuk di pakai di pembelajaran ini
    @Test
    void testUtil() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
    }

}
