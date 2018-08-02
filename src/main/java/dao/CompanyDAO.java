package dao;

import dao.entity.ReportEntity;

import java.util.List;

/**
 * Created by OleksiiF on 02.08.2018.
 */
public interface CompanyDAO {
    void addMillionEmployeesTestData();
    List<ReportEntity> filterEmployeesByAgeInDepartment(int minAge, int maxAge, String district);
}
