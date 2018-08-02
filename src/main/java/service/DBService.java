package service;

import java.io.File;
import java.io.IOException;
import java.sql.*;

/**
 * Created by OleksiiF on 02.08.2018.
 */
public class DBService {

    private static Connection connection;


    public static void createDatabase(String name) throws IOException {
        File file = new File(name + ".db");
        String url = "jdbc:sqlite:"+file.getCanonicalFile().toURI();
        System.out.println(url);

        try(Connection conn = DriverManager.getConnection(url)) {
            connection = conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if (connection != null) {   return connection;  }
        System.out.println("No connection");
        return null;
    }




}
