import java.sql.*;
public class main {
    public static void main(String args[]) throws SQLException{
    	Connection conn = null;
    	Statement stmt1 = null;
       

        try {
        	 Class.forName("org.postgresql.Driver");
             conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Phantom@54010113251");

             conn.setAutoCommit(false);


             conn.setTransactionIsolation (Connection. TRANSACTION_SERIALIZABLE);


            stmt1= conn.createStatement();


 //           stmt1.executeUpdate("UPDATE Product SET prod = 'pp1' WHERE prod = 'p1'");

//            stmt1.executeUpdate("UPDATE Depot SET dep = 'dd1' WHERE dep = 'd1'");


//            stmt1.executeUpdate("DELETE FROM Product WHERE prod = 'p1'");

//            stmt1.executeUpdate("DELETE FROM Depot WHERE dep = 'd1'");
//            stmt1.executeUpdate("INSERT INTO Product(prod, pname, price) VALUES ('p100', 'cd', 5)");
//            stmt1.executeUpdate("INSERT INTO Stock(prod, dep, quantity) VALUES ('p100', 'd2', 50)");
//            stmt1.executeUpdate("INSERT INTO Depot(dep, addr, volume) VALUES ('d100', 'Chicago', 100)");
//            stmt1.executeUpdate("INSERT INTO Stock(prod, dep, quantity) VALUES ('p1', 'd100', 100)");

            conn.commit();

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("An exception was thrown");

            e.printStackTrace();
            conn.rollback();

            stmt1.close();

            conn.close();

            return;

        }
        finally
        {
        	 stmt1.close();

             conn.close();

        }
       
    }
}
