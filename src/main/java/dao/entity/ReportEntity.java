package dao.entity;

/**
 * Created by OleksiiF on 02.08.2018.
 */
public class ReportEntity {
    private String department;
    private String quantity;

    public ReportEntity(String department, String quantity) {
        this.department = department;
        this.quantity = quantity;
    }

    public ReportEntity() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
