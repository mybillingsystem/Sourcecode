import java.sql.*;


public class App {
    public static void main(String[] args){
        Employee e = new Employee();
        //e.bill();
        
    }
}

class Employee{
    
    public void bill(){
        Billing bill = new Billing(1212,"Maggi",12.50F,"ABC",5);
        bill.createBill();    
    }

}
class Manager extends Employee{

}
class Admin extends Manager{

}

class Products {
    int id;
    float price;
    String name;
    String brand;

    void connection () throws Exception{
        Class.forName("com.mariadb.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/billing", "root", "toor");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("show tables;");
        rs.next();
        System.out.println(rs);
        con.close();
    }


    Products(int id,String name,float price,String brand){
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;

    }
   
}
class Billing extends Products{
    int quantity;
    public Billing(int id,String name,float price,String brand,int quantity){
        super(id,name,price,brand);
        
        this.quantity = quantity;
    }
    void createBill() {
        try {
            super.connection();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        Print print = new Print();
        print.printBill(id, name, price, brand, quantity);

    }
    

}
class Print {
    void printBill(int id,String name,float price,String brand,int quantity){
        System.out.println("Id \t Name \t Price \t Quanitity \t Total");
        System.out.println(id+" \t" + name + " \t" + price + " \t" + quantity + " \t" +price*quantity);

    }

}
