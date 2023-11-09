import java.sql.*;
// Docker connection command: mysql -u -root -p
// Password = password
public class DatabaseConnection {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String jdbcUrl = "jdbc:mysql://mysql:3306/testDB";
        String username = "root";
        String password = "password";

        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM employees";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("first_name"));
        }

        connection.close();
    }
}