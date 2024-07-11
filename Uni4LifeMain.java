package Uni4Life;

import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;
public class Uni4LifeMain {
	
	public static void main(String[] args) throws ParseException{
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		AccountHolder accountHolder = new AccountHolder();
		PublishedContents publishedContents = new PublishedContents();
		
		Boolean running = true;
		Boolean loggedIn = false;
		String [] AccountVerificationData = new String[2];
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date launchDate = simpleDateFormat.parse("22/03/2004");

		Account unisinosAccount = new Account("Unisinos","123456");
		Content publicContent = new Content("Uma introdução ao Uni4Life",unisinosAccount,0.0,launchDate,"Artigo");
		Content publicContent2 = new Content("Introdução ao cálculo",unisinosAccount,20.50,launchDate,"Artigo");
		Content publicContent3 = new Content("Introdução à Engenharia de Software",unisinosAccount,50.00,launchDate,"Artigo");
		
		publishedContents.addContent(publicContent);
		publishedContents.addContent(publicContent2);
		publishedContents.addContent(publicContent3);


		
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
				
				AccountVerificationData[0] = accountName;
				AccountVerificationData[1] = accountPassword;
				
				if(accountHolder.verifyAccountInTheList(accountName,accountPassword)==true) {
					
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
		
		if(loggedIn == true) {
			Account academicAccount = accountHolder.getAccountInTheList(AccountVerificationData[0], AccountVerificationData[1]);
			
			do {
				Integer choice = showAccountFunctionalities(sc);
			
				switch(choice) {
				
				case 1:
					
					System.out.println(academicAccount.toString());
					
					break;
					
				case 2:
					
					System.out.print("Informe o saldo a ser adicionado na conta: ");
					
					Double value = sc.nextDouble();
					academicAccount.addCash(value);
					
					break;
				
				case 3:
					publishedContents.showContents();
					sc.nextLine();
					System.out.print("Escreva o nome do conteúdo para procurá-lo: ");
					String publishedContentNameForSearch = sc.nextLine();
					System.out.println(publishedContents.selectPublishedContent(publishedContentNameForSearch));
					
					System.out.print("Você gostaria de adquirir esse conteúdo? [1] - Sim [2] - Não");
					int BuyChoice = sc.nextInt();
					if(BuyChoice == 1) {
						academicAccount.buyContent(publishedContents.selectPublishedContent(publishedContentNameForSearch));
					}
					break;
				
				case 4:
					
					System.out.print("Informe um título: ");
					sc.nextLine();
					String title = sc.nextLine();
					
					System.out.print("Informe o preço do conteúdo: ");
					Double contentValue = sc.nextDouble();
					
					System.out.print("Informe o tipo de arquivo a ser postado. Você pode postar um artigo, vídeo ou um podcast: ");
					String contentType = sc.next();
					
					LocalDate localDate = LocalDate.now();
					Date publishDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
					
					Content newContent = new Content(title,academicAccount,contentValue,publishDate,contentType);
					academicAccount.postContent(newContent);
					publishedContents.addContent(newContent);
					
					break;
					
				case 5:
					if(academicAccount.getContentLibrary().size()>0) {
						
						System.out.print("Digite o nome do conteúdo: ");
						sc.nextLine();
						String titleSearch = sc.nextLine();
						
						for(int i=0;i < academicAccount.getContentLibrary().size();i++) {
							if(titleSearch.equals(academicAccount.getContentLibrary().get(i).contentName)) {
								System.out.println(academicAccount.getContentLibrary().get(i).toString());
							}
						}
					}
					else {
						System.out.println("Você não possui conteúdos adquiridos");
						
					}
					
					break;
					
				case 6:
					System.out.println("Saindo...");
					loggedIn = false;
				}
			}
		while(loggedIn == true);	
	}
	
		sc.close();
	}
	public static Account createAccount(String accountName, String accountPassword) {
		
		Account academicAccount = new Account(accountName,accountPassword);
		return academicAccount;
		
	}
	
	public static void saveAccount(AccountHolder accountHolder,Account academicAccount) {
		accountHolder.addAcountToTheList(academicAccount);
		
	}

	
	public static Integer showFunctionalities(Scanner sc) {
		System.out.printf("[1] - Criar nova conta%n[2] - Realizar Login%n[3] - Sair%nDigite uma opção: ");
		Integer choice = sc.nextInt();
		return choice;
	}
	
	public static Integer showAccountFunctionalities(Scanner sc) {
		System.out.printf("[1] - Mostrar dados da conta%n[2] - Adicionar saldo à conta%n[3] - Procurar conteúdo%n[4] - Criar Conteúdo%n[5] - Procurar conteúdo na biblioteca%n[6] - Sair%nDigite uma opção: ");
		Integer choice =sc.nextInt();
		return choice;
	}
	
	
}
