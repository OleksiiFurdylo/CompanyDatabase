import dao.impl.DBdaoSQLITEimpl;
import service.DBService;

import java.util.Scanner;

import static service.ReportService.filterEmployeesByAgeInDepartment;

/**
 * Created by OleksiiF on 02.08.2018.
 */
public class Run {
    public static void main(String[] args) throws Exception {


        Run.prepareEnvironment();
        Run.runFilterTask();


    }
        private static void prepareEnvironment() throws Exception {

            System.out.println("Preparing Environment");
            DBService.createDatabase("test");
            DBService.createStructureForDatabase(DBdaoSQLITEimpl.getConnection());

            System.out.println("Adding 1M Employees");
            DBService.addMillionEmployeesTestData();
        }

        private static void runFilterTask(){
            System.out.println("Filter query in process...");

            filterEmployeesByAgeInDepartment(getMinAgeValuesForFilter(), getMaxAgeValuesForFilter(), getDeptNameForFilter())
                    .stream()
                    .forEach((i) -> System.out.println(i.getDepartment() + " | "+ i.getQuantity()));
        }

        private static int getMinAgeValuesForFilter(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter minimum Age:");
            return sc.nextInt();
        }

        private static int getMaxAgeValuesForFilter(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter maximum Age:");
            return sc.nextInt();
        }

        private static String getDeptNameForFilter(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Department Name (Uptown, Downtown, Underworld) :");
            return sc.next();
        }

}


