package hanifiamdev.com.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {


    @BeforeAll
    static void beforeAll() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void testConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
        String username = "root";
        String password = "+5199_MgK";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("Sukses konek ke database");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }

    }

    @Test
    void testConnectionClose() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
        String username = "root";
        String password = "+5199_MgK";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("Sukses konek ke database");

            connection.close();
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }

    }

    //close sebenarnya interface Autocloseable, sehingga tidak perlu close coneection manual juga bisa
    @Test
    void testConnectionClose2() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
        String username = "root";
        String password = "+5199_MgK";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);){
            System.out.println("Sukses konek ke database");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }

    }
}
