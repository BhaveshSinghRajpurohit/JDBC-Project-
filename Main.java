// com.mysql.jdbc.Driver = isme sare drivers pde hue hai jdbs ke to ab is se hum unko load kr rhe hai
import java.sql.*;
public class Main{
    public static void main(String[] args) throws ClassNotFoundException{

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Your_Password";
//        String query =" insert into employees values(8,'ankit','design',20000.0);";
        String query =" select name from employees where salary>90000;";
       try {
        Class.forName("com.mysql.jdbc.Driver");
           System.out.println("drivers loaded successfully");
       }
       catch (ClassNotFoundException e){
           System.out.println(e.getMessage());
       }

       try{
           Connection con = DriverManager.getConnection(url,username,password);
           System.out.println("connection established succesfully");
           Statement stmt= con.createStatement();
//            is statement mai do operation hote hai
//           ek stmt.executequery() = ye query ya result show ke liye
//                   dusri stmt.executeupdate()= ye value insert ke liye
           int rowsaffected = stmt.executeUpdate(query);
           if(rowsaffected>0){
               System.out.println("insert successfull "+rowsaffected+ " row is affected");
           }
           else {
               System.out.println("insertion failed");
           }


          stmt.close();
          con.close();
           System.out.println("connection closed succesfully");
       }
       catch (SQLException e){
           System.out.println(e.getMessage());
       }

    }
}