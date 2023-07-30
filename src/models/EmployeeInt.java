package models;

public interface EmployeeInt {
    public void createEmployee(Employee emp);
    public void showAllEmployee();
    public void showEmployeeBasedOnIn(int id);
    public void updateEmployee(int id, String name);
    public void deleteEmployee(int id);

}
