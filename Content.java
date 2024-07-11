package Uni4Life;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Content {
	public String contentName;
	public Account author;
	public Double value;
	public Date publishDate;
	public String type;
	
	public Content(String contentName, Account author, Double value, Date publishDate, String type) {
		this.contentName = contentName;
		this.author = author;
		this.value = value;
		this.publishDate = publishDate;
		this.type = type;
	}
	
	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("Titulo: %s%nNome do autor: %s%nPreço: R$%.2f%nTipo de conteúdo: %s%nPostado em: ",this.contentName,this.author.getName(),this.value,this.type) + sdf.format(this.publishDate);  
	}
}

