package Uni4Life;
import java.util.List;
import java.util.ArrayList;

public class Account {
	private String accountName;
	private String password;
	private Double balance;
	private List<Content> contentLibrary = new ArrayList<>();
	private List<Content> itsContents = new ArrayList<>();
	
	public Account(String name,String password) {
		this.accountName = name;
		this.password = password;
		this.balance = 0.0;
	}
	
	public void buyContent(Content content) {
		if(content.value>this.balance) {
			System.out.println("Saldo insuficiente");
		}
		else {
			this.balance -= content.value;
			contentLibrary.add(content);
		}
	}
	
	public void postContent(Content content) {
		this.itsContents.add(content);
	}
	public String getName() {
		return accountName;
	}
	public void addCash(Double cash) {
		this.balance +=cash;
		System.out.printf("Valor adicionado com sucesso! Seu saldo atual é %.2f%n",this.balance);
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
	
	public String toString() {
		return String.format("Nome: %s%nSaldo: %.2f%nConteúdos adquiridos: ", this.accountName,this.balance) + this.contentLibrary + String.format("%nConteúdos postados: ") + this.itsContents;
		
	}
}
