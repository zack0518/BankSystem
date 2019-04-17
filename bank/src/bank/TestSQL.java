package bank;

public class TestSQL {
  public static void main(String args[]) {
    try {
     Class.forName("com.mysql.jdbc.Driver"); 
     System.out.println("Success loading Mysql Driver!");
    }
    catch (Exception e) {
      System.out.print("Error loading Mysql Driver!");
      e.printStackTrace();
    }
    
    Inquire usertable = new Inquire("user");
    Insert user = new Insert("Xiao", "123456"); //user table, id auto generate
    											// (id, username, password)
    Insert transact = new Insert("2019.4.7", "2" , "3" , "500"); //transaction table, id auto generate
    														// (id, date, formUserID, toUserID, money)
  }
}
