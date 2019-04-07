package bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insert {

	// user table
	public Insert(String username, String password) {
		String ID = null;
		try {
		      Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://127.0.0.1:3306/BankProject?characterEncoding=utf8&useSSL=true","root","xsjxsjxsj");
		      System.out.println("Success connect Mysql server!");
		     
		      Statement stmt = connect.createStatement();
		      ResultSet rs = stmt.executeQuery("select * from user");
		      while (rs.next()) {
		    	  rs.last();
		    	  int id = Integer.parseInt(rs.getString("ID")) + 1;
		    	  ID = String.valueOf(id);
		      }
		      Statement Statement= connect.createStatement();
		      Statement.executeUpdate("Insert INTO user values("+"'" + ID + "'" + "," + "'" + username + "'" + "," + "'"+ password +"'" +")");
		      
		    }
		    catch (Exception e) {
		      System.out.println("get data error!");
		      e.printStackTrace();
		    }
	}
	
	// transaction
	public Insert(String date, String fromUserID, String toUserID, String money) {
		String ID = null;
		
		try {
		      Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://127.0.0.1:3306/BankProject?characterEncoding=utf8&useSSL=true","root","xsjxsjxsj");
		      System.out.println("Success connect Mysql server!");
		      
		      Statement stmt = connect.createStatement();
		      ResultSet rs = stmt.executeQuery("select * from transaction");     
		      while (rs.next()) {
		    	  rs.last();
		    	  int id = Integer.parseInt(rs.getString("ID")) +1;
		    	  ID = String.valueOf(id);
		      }
		      Statement Statement= connect.createStatement();
		      Statement.executeUpdate("Insert INTO transaction values("+"'" + ID + "'," + "'" + date + "'," + "'"+ 
		      fromUserID +"'," +"'" + toUserID +"',"+ "'" + money + "'" +")");
		    }
		    catch (Exception e) {
		      System.out.println("get data error!");
		      e.printStackTrace();
		    }
	}
}

