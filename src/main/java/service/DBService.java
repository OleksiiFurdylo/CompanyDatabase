package service;

import dao.impl.CompanyDaoSQLITEimpl;
import dao.impl.DBdaoSQLITEimpl;

import java.io.IOException;
import java.sql.*;

/**
 * Created by OleksiiF on 02.08.2018.
 */
public class DBService {
    //static DBdao dbdao;
    //static CompanyDAO companyDao;
    static CompanyDaoSQLITEimpl companyDaoSQLITEimpl;
    static DBdaoSQLITEimpl dBdaoSQLITEimpl;


    public static void createDatabase(String name) throws IOException {
        dBdaoSQLITEimpl.createDatabase(name);
    }

    public static Connection getConnection() throws Exception {
        return dBdaoSQLITEimpl.getConnection();
    }

    public static void createStructureForDatabase(Connection conn){
        dBdaoSQLITEimpl.createStructureForDatabase(conn);

    }

    public static void addMillionEmployeesTestData(){
        companyDaoSQLITEimpl.addMillionEmployeesTestData();
    }



}
