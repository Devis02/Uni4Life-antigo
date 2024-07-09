package Uni4Life;

import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Uni4LifeMain {
	public static void main(String[] args) throws ParseException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Date publishDate = simpleDateFormat.parse("23/03/2024");
		
		Account author = new Account("Jorge","123445");
		Content content = new Content("CÁLCULO I: Uma breve introdução",author,10.50,publishDate,"Artigo");
		Content SoftwareEngineerContent = new Content("Engenharia de Software: Padrões de Projeto",author,0.0,publishDate,"Artigo");
	
		Account student = new Account("Maria","123456");
		
		student.addCash(20.00);
		System.out.println("Balance: "+student.getBalance());
		
		System.out.println("[Buy content Use Case]");
		student.buyContent(content);
		System.out.println("Balance: "+student.getBalance());

		student.buyContent(SoftwareEngineerContent);
		System.out.println(student.getContentLibrary());
		System.out.println("Balance: "+student.getBalance());
		
		System.out.println("[Find Content Use Case]");
		System.out.println(student.getContentLibrary().get(student.getContentLibrary().indexOf(SoftwareEngineerContent)));
		
	}
}
