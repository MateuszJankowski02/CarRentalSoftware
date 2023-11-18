package carRental;
import java.sql.*;
// Docker connection command: mysql -u -root -p
// Password = password
public class DatabaseConnection {
   static void connectDB(String dbname, String username, String password) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String jdbcUrl = "jdbc:mysql://mysql:3306/" + dbname;  //testDB

        Connection connection = DriverManager.getConnection(jdbcUrl, username, password); // username: root ; password: password;

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM employees";
        ResultSet resultSet = statement.executeQuery(sql);

//        while (resultSet.next()) {
//            System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("first_name"));
//        }

        connection.close();
    }
}