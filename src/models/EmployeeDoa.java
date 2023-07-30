package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDoa implements EmployeeInt{
    Connection con;
    @Override
    public void createEmployee(Employee emp) {
        con=DBConnection.createDBConnection();
        String query ="INSERT INTO amina (id,name,salary,age) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setInt(3,emp.getSalary());
            pstm.setInt(4, emp.getAge());
            int cnt = pstm.executeUpdate();
            if(cnt!=0){
                System.out.println("Employee Inserted Successfuly");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void showAllEmployee() {
        con=DBConnection.createDBConnection();
        String query="select * from amina";
        System.out.println("Employee Details ");
        try{
           Statement stmt =con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%d\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4)
                );

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnIn(int id) {
        con =DBConnection.createDBConnection();
        String query ="select * from amina where id ="+id;
        try {
            Statement stmt =con.createStatement();
            ResultSet result =stmt .executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%d\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4)
                );

            }


        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(int id, String name) {
        con=DBConnection.createDBConnection();
        String query ="update amina set name=? where id=?";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,name);
            stmt.setInt(2, id);
          int cnt=  stmt.executeUpdate();
          if (cnt!=0){
              System.out.println("Employee Details updated successfuly ");
          }


        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        con=DBConnection.createDBConnection();
        String query = "DELETE from amina where id=? ";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
           int cnt= stmt.executeUpdate();
           if (cnt!=0){
               System.out.println("Employee Deleted Succefully");
           }


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
