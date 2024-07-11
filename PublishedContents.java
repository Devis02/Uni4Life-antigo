package Uni4Life;

import java.util.ArrayList;
import java.util.List;

public class PublishedContents {
	private List <Content> publishedContents = new ArrayList<>();
	
	public Content selectPublishedContent(String contentName) {
		
		for (int i=0;i<publishedContents.size();i++) {
			
			if(contentName.equals(publishedContents.get(i).contentName)) {
				return publishedContents.get(i);
			}
		}
		
		return null;
	}
	
	public void addContent(Content content) {
		this.publishedContents.add(content);
	}

	public void showContents() {
		for (int i=0;i<publishedContents.size();i++) {
			System.out.println(publishedContents.get(i).toString());
		}
	}
}

