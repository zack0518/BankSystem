package bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Inquire {
	public static String table;
	
	public Inquire(String tablename) {
		Inquire.table = tablename;
		int column = 0;
		if (table == "user") {
			column = 3;
		} else if (table ==  "transaction") {
			column = 5;
		}
		
		try {
		      Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://127.0.0.1:3306/BankProject?characterEncoding=utf8&useSSL=true","root","xsjxsjxsj");
		           //连接URL为   jdbc:mysql//服务器地址/数据库名?...  ，后面的2个参数分别是登陆用户名和密码

		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      ResultSet rs = stmt.executeQuery("select * from " + table);
		      
		while (rs.next()) {
			for (int i =1 ; i<=column; i++) {
				System.out.println(rs.getString(i));
					}
			System.out.println("------------------");
		    	}
		    }
		    catch (Exception e) {
		      System.out.println("get data error!");
		      e.printStackTrace();
		    }
	}

}

