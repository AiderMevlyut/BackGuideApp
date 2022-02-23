package demo.database;

import demo.model.Words;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
//        ConnectionDB connectionDB = new ConnectionDB();
//        connectionDB.getConnection();

        System.out.println(getAllListWordsTest());
    }

    public static List<Words> getAllListWordsTest() {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        String URL = "jdbc:postgresql://kashin.db.elephantsql.com/uqdedbbb";
        String USERNAME = "uqdedbbb";
        String PASSWORD = "CPPm678wl7lrs_9tfhzv-l37Wmzxnclu";

        List<Words> wordsList = new ArrayList<>();
        Words words;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Words");

            if (statement.execute("select * from Words")) {
                resultSet = statement.getResultSet();

                while (resultSet.next()) {
                    int id = resultSet.getInt("Id");
                    String name = resultSet.getString("name");
                    String transcription = resultSet.getString("transcription");
                    String image = resultSet.getString("image");
                    String translate = resultSet.getString("translate");
                    String category = resultSet.getString("category");
                    String language = resultSet.getString("language");
                    String translateTo = resultSet.getString("translateTo");

                    words = new Words(id, name, transcription, image, translate, category, language, translateTo);
                    wordsList.add(words);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wordsList;
    }
}
