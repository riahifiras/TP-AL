import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	private static Connection myConn;
	private static Statement instruction;

	public  ConnectDB() {
		// TODO Auto-generated method stub
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ii2", "root", "root");
			instruction = myConn.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection connectDB() {
		// TODO Auto-generated method stub
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ii2", "root", "root");
			instruction = myConn.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myConn;
	}
	
	public ResultSet execute(String query) {
		try {
			ResultSet result = instruction.executeQuery(query);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
		
	}
	
	public void update(String query) {
		int yes;
		try {
			yes = instruction.executeUpdate(query);
			System.out.println(yes + "rows affected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void close() {
        try {
            if (instruction != null) {
                instruction.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
