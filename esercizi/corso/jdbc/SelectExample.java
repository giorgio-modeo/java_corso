package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SelectExample {
    public static void main(String[] args) {
        DatabaseInit db = new DatabaseInit();
        Connection conn = db.connectionToDb(); // apertura connessione al db
        String description = "programmatore";
        Statement stmt;
        {
            try{
                stmt = conn.createStatement();
                String query =
                            "SELECT e.id, e.firstname, e.lastname, e.dob, e.hire_date, j.description FROM employee e, job j "+
                            "WHERE j.id = e.job " +
                            "AND j.description = '"+description+"'"+
                            "ORDER BY lastname";
                ResultSet rs = stmt.executeQuery(query);

                List<Employee> employees = new ArrayList<>();

                while (rs.next()){
                    Employee e = new Employee(
                            rs.getInt("Id"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getDate("dob").toLocalDate(),
                            rs.getDate("hire_date").toLocalDate(),
                            rs.getString("description")

                    );
                    System.out.println(e.toString());
                    employees.add(e);
                    /*
                    System.out.println("Id: "+rs.getInt("id")+" ");
                    System.out.println("Firstname: "+rs.getString("firstname")+" ");
                    System.out.println("Lastname: "+rs.getString("lastname")+" ");
                    System.out.println("Dob: "+rs.getDate("dob")+" ");
                    System.out.println("Hire date: "+rs.getDate("hire_date")+" ");
                    */
                }db.closeConnection(conn);
            }catch(SQLException e){
                System.err.println("QUALCOSA E ANDATO STORTO NELL'ESECUZZIONE DELLA QUERY"+e.getMessage());
            }
        }
    }
}
