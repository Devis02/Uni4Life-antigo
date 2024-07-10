package Uni4Life;
import java.util.List;
import java.util.ArrayList;

public class Account {
	private String accountName;
	private String password;
	private Double balance;
	private List<Content> contentLibrary = new ArrayList<>();
	
	public Account(String name,String password) {
		this.accountName = name;
		this.password = password;
		this.balance = 0.0;
	}
	
	public void buyContent(Content content) {
		this.balance -= content.value;
		contentLibrary.add(content);
	}
	
	public String getName() {
		return accountName;
	}
	public void addCash(Double cash) {
		this.balance +=cash;
	}
	
	public Double getBalance() {
		return this.balance;
	}
	
	public List<Content> getContentLibrary() {
		return this.contentLibrary;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	public Boolean verification(String passwordVerification) {
		if(this.password.equals(passwordVerification)) {
			return true;
		}
		else {
			return false;
		}
	}
}
