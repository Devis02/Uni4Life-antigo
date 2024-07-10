package Uni4Life;

import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class Uni4LifeMain {
	
	public static void main(String[] args) throws ParseException{
		
		Scanner sc = new Scanner(System.in);
		AccountHolder accountHolder = new AccountHolder();
		Boolean running = true;
		Boolean loggedIn = false;
		
		do {
			Integer choice = showFunctionalities(sc);
			
			switch(choice) {
			
			case 1:
				
				System.out.print("Digite um nome para sua conta: ");
				String accountName = sc.next();
				
				System.out.print("Digite uma senha para sua conta: ");
				String accountPassword = sc.next();
				
				Account academicAccount = createAccount(accountName,accountPassword);
				saveAccount(accountHolder,academicAccount);
				break;
			case 2:
				
				System.out.print("Digite o nome de sua conta: ");
				accountName = sc.next();
				
				System.out.print("Digite a senha de sua conta: ");
				accountPassword = sc.next();
				Account accountAccess = createAccount(accountName,accountPassword);
				if(accountHolder.verifyAccountInTheList(accountAccess,accountPassword)==true) {
					System.out.println("Entrando...");
					loggedIn = true;
				}
				else {
					System.out.println("Valores inválidos");
				}
				break;
			case 3:
				
				running = false;
				break;
			}
		}
		while(running != false && loggedIn == false);
		
		sc.close();
	}
	
	public static Account createAccount(String accountName, String accountPassword) {
		
		Account academicAccount = new Account(accountName,accountPassword);
		return academicAccount;
		
	}
	
	public static void saveAccount(AccountHolder accountHolder,Account academicAccount) {
		accountHolder.addAcountToTheList(academicAccount);
		
	}

	public static void realizeLogin() {
		
	}
	
	public static Integer showFunctionalities(Scanner sc) {
		System.out.printf("[1] - Criar nova conta%n[2] - Realizar Login%n[3] - Sair%nDigite uma opção: ");
		Integer choice = sc.nextInt();
		return choice;
	}
	
}
