package hanifiamdev.com.database;

import org.junit.jupiter.api.Test;

import javax.xml.transform.Result;
import java.sql.*;

public class AutoIncrementTest {

    @Test
    void testAutoIncrement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


        preparedStatement.setString(1, "testAutoIncrement.com");
        preparedStatement.setString(2, "test Auto Increment");


        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()) {
            System.out.println("Id Comment : " + resultSet.getInt(1));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }


}
