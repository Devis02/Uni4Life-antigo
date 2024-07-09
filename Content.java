package Uni4Life;
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
		return String.format("Content name: %s%nAuthor name: %s%nPrice: R$%.2f%nType of content: %s%nPublish date: ",this.contentName,this.author.getName(),this.value,this.type) + this.publishDate;  
	}
}

