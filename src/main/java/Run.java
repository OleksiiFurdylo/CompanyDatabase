import dao.CompanyDAO;
import service.DBService;

import java.io.File;
import java.io.IOException;
import java.sql.*;

/**
 * Created by OleksiiF on 02.08.2018.
 */
public class Run {
    public static void main(String[] args) throws IOException {
        CompanyDAO companyDAO = new CompanyDAO();

        DBService.createDatabase("test");
        DBService.createStructureForDatabase(DBService.getConnection());
        companyDAO.addMillionEmployeesTestData();

    }

}
