package bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transact {
	private String userID;
	
	public Transact(String userID) {
		this.userID = userID;
	}
	
	public void transfer(String toID, double amount) {
		String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		Insert update = new Insert(time, userID, toID, Double.toString(amount));
	}
}
