package dao;

import org.fluttercode.datafactory.impl.DataFactory;
import service.DBService;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.IntStream;

/**
 * Created by OleksiiF on 02.08.2018.
 */
public class CompanyDAO {

    DataFactory df = new DataFactory();

    public void addMillionEmployeesTestData(){
        try {
            Statement st = DBService.getConnection().createStatement();
            //addStuff(st);
            //addEmployees(st);


            try {

                st.execute("INSERT INTO companies (company_name) VALUES ('Company A'), ('Company B')");

                for(int i=0; i<1000; i++) {
                    st.execute("INSERT INTO employees (department_id) VALUES (" + df.getNumberBetween(1, 10) + ")");
                    st.execute("INSERT INTO staff (name, age) VALUES ('" + df.getFirstName() + "', " + df.getNumberBetween(16, 100) + ")");

                    System.out.println(i);
                }

                for(int i=0; i<10; i++) {
                    st.execute("INSERT INTO employees (department_id) SELECT department_id FROM employees");

                    st.execute("INSERT INTO staff (name, age) SELECT name, age FROM staff");
                    st.execute("INSERT INTO departments (department_name, district_name, company_id) " +
                            "VALUES ('"+ df.getCity() + "Department" +"', '"+df.getRandomWord(4, 5) + "', " + df.getNumberBetween(1, 3) + ")");
                }



                System.out.println("Inserted");

            } catch (SQLException e) {
                e.printStackTrace();
            }


            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

/*    private void addEmployees(Statement st) {
        try {

            for(int i=0; i<1000; i++) {
                st.execute("INSERT INTO employees (department_id) VALUES (" + df.getNumberBetween(1, 10) + ")");
                System.out.println(i);
            }
            for(int i=0; i<10; i++) {
                st.execute("INSERT INTO employees (department_id) SELECT department_id FROM employees");
            }
            System.out.println("Inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addStuff(Statement st){
        try {

        for(int i=0; i<1000; i++) {
            st.execute("INSERT INTO staff (name, age) VALUES ('" + df.getFirstName() + "', " + df.getNumberBetween(16, 100) + ")");
            System.out.println(i);
        }
        for(int i=0; i<10; i++) {
            st.execute("INSERT INTO staff (name, age) SELECT name, age FROM staff");
        }
        System.out.println("Inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/

}
