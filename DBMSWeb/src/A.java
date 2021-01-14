import java.sql.*;
class A{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbms","root","crysis123");
//here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from student");
            while(rs.next()){
                String usn = rs.getString(1);
                String name = rs.getString(2);
                String sem = rs.getString(3);
                out.println(usn + " " + "");
            }

            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}  