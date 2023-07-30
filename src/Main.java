import models.Employee;
import models.EmployeeDoa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         EmployeeDoa dao =new EmployeeDoa();
        System.out.println("Welcome to Employee management application");
        Scanner reader= new Scanner(System.in);

        do{
            System.out.println("1. Add Employee\n"+
                    "2. Show All Employee\n"+
                    "3. Show Employee based on id \n"+
                    "4. Update the employee\n"+
                    "5. Delete the employee\n"
                    );
            System.out.println("Enter Choice");
            int ch= reader.nextInt();
            switch(ch){
                case 1:
                    Employee emp = new Employee();
                    System.out.println("Enter ID : ");
                    int id = reader.nextInt();
                    System.out.println("Enter name : ");
                    String name = reader.next();
                    System.out.println("Enter Salary : ");
                    int salary = reader.nextInt();
                    System.out.println("Enter Age : ");
                    int age = reader.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createEmployee(emp);
                    break;
                case 2 :
                    dao.showAllEmployee();
                    break;
                case 6:
                    System.out.println("Thank you for using our Application  ");
                     System.exit(0);
                default:
                    System.out.println("Enter valid choice");
                    break;

            }


        }while(true);
    }
}