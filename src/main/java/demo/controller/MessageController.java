package demo.controller;

import demo.database.ConnectionDB;
import demo.exceptions.NotFoundException;
import demo.model.Words;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("data")
public class MessageController {
    private int counter = 4;

//    private ConnectionDB connection;
//    private Statement statement;
//    private ResultSet resultSet;

    List<Words> messages = new ArrayList<Words>();

//    private void getConnection() {
//        Connection connection = null;
//        String URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11471478";
//        String USERNAME = "sql11471478";
//        String PASSWORD = "rWvpVWN3Zb";
//
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("select * from Customers");
//
//            if (statement.execute("select * from Customers")) {
//                resultSet = statement.getResultSet();
//
//                while (resultSet.next()) {
//                    System.out.println(resultSet.getString("FirstName"));
//                    int id = resultSet.getInt("Id");
//                    String message = resultSet.getString("FirstName");
//
//                    messages.add(new HashMap<String, String>() {{
//                        put("id", Integer.toString(id));
//                        put("text", message);
//                    }});
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
//        add(new HashMap<String, String>() {{ put("id", "1"); put("text", "First message"); }});
//        add(new HashMap<String, String>() {{ put("id", "2"); put("text", "Second message"); }});
//        add(new HashMap<String, String>() {{ put("id", "3"); put("text", "Third message"); }});
//    }};

    @GetMapping
    public List<Words> getAllListWords() {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        String URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11473444";
        String USERNAME = "sql11473444";
        String PASSWORD = "Q35HAZPata";

        List<Words> wordsList = new ArrayList<>();
        Words words = new Words();

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

//    @GetMapping("{id}")
//    public Map<String, String> getOne(@PathVariable String id) {
//        return getMessage(id);
//    }

//    private Map<String, String> getMessage(@PathVariable String id) {
//        return messages.stream()
//                .filter(message -> message.get("id").equals(id))
//                .findFirst()
//                .orElseThrow(NotFoundException::new);
//    }
//
//    @PostMapping
//    public Map<String, String> create(@RequestBody Map<String, String> message) {
//        message.put("id", String.valueOf(counter++));
//
//        messages.add(message);
//
//        return message;
//    }

//    @PutMapping("{id}")
//    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
//        Map<String, String> messageFromDb = getMessage(id);
//
//        messageFromDb.putAll(message);
//        messageFromDb.put("id", id);
//
//        return messageFromDb;
//    }
//
//    @DeleteMapping("{id}")
//    public void delete(@PathVariable String id) {
//        Map<String, String> message = getMessage(id);
//
//        messages.remove(message);
//    }
}