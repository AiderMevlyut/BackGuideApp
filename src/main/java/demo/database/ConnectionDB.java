package demo.database;

import java.sql.*;

public class ConnectionDB {
    private ConnectionDB connection;
    private Statement statement;
    private ResultSet resultSet;

    private void getConnection(){
        Connection connection = null;
        String URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11471478";
        String USERNAME = "sql11471478";
        String PASSWORD = "rWvpVWN3Zb";

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Customers");

            if (statement.execute("select * from Customers")) {
                resultSet = statement.getResultSet();

                while (resultSet.next()){
                    System.out.println(resultSet.getString("FirstName"));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConnectionDB connectionDB = new ConnectionDB();
        connectionDB.getConnection();
    }
}
