package service;

import dao.entity.ReportEntity;
import dao.impl.CompanyDaoSQLITEimpl;

import java.util.List;

/**
 * Created by OleksiiF on 02.08.2018.
 */
public class ReportService {
    //static CompanyDAO companyDao;
    static CompanyDaoSQLITEimpl companyDaoSQLITEimpl;

    public static List<ReportEntity> filterEmployeesByAgeInDepartment(int minAge, int maxAge, String district){
        return companyDaoSQLITEimpl.filterEmployeesByAgeInDepartment(minAge, maxAge, district);
    }
}
