package dao.impl;

import dao.entity.ReportEntity;
import org.fluttercode.datafactory.impl.DataFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OleksiiF on 02.08.2018.
 */
public class CompanyDaoSQLITEimpl {

    static DataFactory df = new DataFactory();
    static String[] districtNames = {"Uptown", "Downtown", "Underworld"};

    public static void addMillionEmployeesTestData(){
        try {
                Statement st = DBdaoSQLITEimpl.getConnection().createStatement();

                st.execute("INSERT INTO companies (company_name) VALUES ('Company A'), ('Company B')");

                for (int i = 0; i < 1000; i++) {
                    st.execute("INSERT INTO employees (department_id) VALUES (" + df.getNumberBetween(1, 11) + ")");
                    st.execute("INSERT INTO staff (name, age) VALUES ('" + df.getFirstName() + "', " + df.getNumberBetween(16, 100) + ")");
                }

                for (int i = 0; i < 10; i++) {
                    st.execute("INSERT INTO employees (department_id) SELECT department_id FROM employees");
                    st.execute("INSERT INTO staff (name, age) SELECT name, age FROM staff");
                    st.execute("INSERT INTO departments (department_name, district_name, company_id) " +
                            "VALUES ('" + df.getCity() + "Department" + "', '" + districtNames[df.getNumberBetween(0, districtNames.length)] + "', " + df.getNumberBetween(1, 3) + ")");
                }
                st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<ReportEntity> filterEmployeesByAgeInDepartment(int minAge, int maxAge, String district) {

        List<ReportEntity> reportEntities = new ArrayList<>(Arrays.asList(new ReportEntity("Department", "Employees")));

        String sqlReportStatement = "SELECT count(employees.staff_id), departments.department_name\n" +
                "FROM employees\n" +
                "  INNER JOIN departments ON departments.department_id = employees.department_id\n" +
                "  INNER JOIN staff ON staff.staff_id = employees.staff_id\n" +
                "WHERE staff.age > "+ minAge +" AND staff.age < "+ maxAge +" AND departments.district_name LIKE '" + district + "'\n" +
                "GROUP BY departments.department_name;";

        try {
            PreparedStatement st = DBdaoSQLITEimpl.getConnection().prepareStatement(sqlReportStatement);

            ResultSet rs = st.executeQuery();
            while (rs.next()){
                ReportEntity reportEntity = new ReportEntity();
                reportEntity.setQuantity(rs.getString(1));
                reportEntity.setDepartment(rs.getString(2));

                reportEntities.add(reportEntity);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reportEntities;
    }

}
