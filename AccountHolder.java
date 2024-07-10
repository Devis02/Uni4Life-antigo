package Uni4Life;

import java.util.ArrayList;
import java.util.List;

public class AccountHolder {
	private List <Account> accountHolder = new ArrayList<>();
	
	public Account getAccount(Account account) {
		return this.accountHolder.get(accountHolder.indexOf(account));
	}
	
	public void addAcountToTheList(Account account) {
		this.accountHolder.add(account);
	}
	
	public Boolean verifyAccountInTheList(Account accountAccess, String password) {
		
		for(int i=0;i<this.accountHolder.size();i++) {
			if(accountAccess.getName().equals(this.accountHolder.get(i).getName()) && this.accountHolder.get(i).verification(password) == true) {
				return true;
			}
		}
		return false;
	}
		
	public List<Account> getListOfAccounts(){
		return this.accountHolder;
	}
	

}


