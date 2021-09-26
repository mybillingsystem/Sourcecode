import java.sql.*;

public class test {
        public static void main(String[] args) throws Exception{
            Connection con = null;            
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Connecting..");
            //con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/", "root", "");
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/", "root", "toor");
            System.out.println("Connected");
            Statement stmt=con.createStatement();  
            stmt.executeQuery("USE UNIVERSITY;");
            ResultSet rs = stmt.executeQuery("SELECT * FROM instructor;");
            while(rs.next())  
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
            con.close();
        }
}
