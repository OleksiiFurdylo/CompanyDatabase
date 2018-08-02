package service;

import java.io.File;
import java.io.IOException;
import java.sql.*;

/**
 * Created by OleksiiF on 02.08.2018.
 */
public class DBService {
    private static Connection connection;

    private static String createStaff =     "CREATE TABLE IF NOT EXISTS staff (\n"
                                            + "	staff_id integer  PRIMARY KEY AUTOINCREMENT,\n"
                                            + "	name text NOT NULL,\n"
                                            + "	age real\n"
                                            + ");";

    private static String createCompanies = "CREATE TABLE IF NOT EXISTS companies (\n"
                                            + "	company_id integer PRIMARY KEY AUTOINCREMENT,\n"
                                            + "	company_name text NOT NULL\n"
                                            + ");";

    private static String createEmployees = "CREATE TABLE IF NOT EXISTS employees (\n"
                                            + "	staff_id integer PRIMARY KEY AUTOINCREMENT,\n"
                                            //+ "	employee_id integer, \n"
                                            + "	department_id integer,\n"
                                            + " FOREIGN KEY (department_id) REFERENCES departments(department_id)\n"
                                            + ");";

    private static String createDepartments = "CREATE TABLE IF NOT EXISTS departments (\n"
                                            + "	department_id integer PRIMARY KEY AUTOINCREMENT,\n"
                                            + "	department_name text NOT NULL,\n"
                                            + "	district_name text NOT NULL,\n"
                                            + "	company_id integer,\n"
                                            + " FOREIGN KEY (company_id) REFERENCES companies(company_id)\n"
                                            + ");";






    public static void createDatabase(String name) throws IOException {
        File file = new File(name + ".db");
        String url = "jdbc:sqlite:"+file.getCanonicalFile().toURI();
        System.out.println(url);

        try {
            Connection conn = DriverManager.getConnection(url);
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

    public static void createStructureForDatabase(Connection conn){

        try {
            Statement st = conn.createStatement();

            st.execute(createStaff);
            st.execute(createCompanies);
            st.execute(createEmployees);
            st.execute(createDepartments);

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
