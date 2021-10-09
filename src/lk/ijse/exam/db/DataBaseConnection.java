package lk.ijse.exam.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static DataBaseConnection dataBaseConnection=null;
    private Connection connection;

    private DataBaseConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ThogaKade",
                "root","1234"
        );
    }
    public static DataBaseConnection getInstance() throws SQLException, ClassNotFoundException {
       return (dataBaseConnection==null?
               (dataBaseConnection=new DataBaseConnection()):(dataBaseConnection));
    }

    public Connection getConnection(){
        return connection;
    }
}
