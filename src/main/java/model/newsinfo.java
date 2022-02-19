package model;

import model.thenewsdb.Article;

//class newsinfo includes what the exercise requires such as title,description etc. It also includes constructors, getters and setters.
//I create variables of what is required
public class newsinfo {
	private String title;
	private String description;
	private String post_date;
	private String url_location;;
	
//I define constructors	
	public newsinfo(String title, String description, String post_date, String url_location, String country) {
		super();
		this.title = title;
		this.description = description;
		this.post_date = post_date;
		this.url_location = url_location;
	}
//This class is used in order to bring the articles' results	
	public newsinfo(Article theResult) {
		
		this.title= theResult.getTitle();
		this.description=theResult.getDescription();
		this.post_date=theResult.getPublishedAt();
		this.url_location=theResult.getUrl();
	}
//I create getters
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getPost_date() { 
		return post_date;
	}

	public String getUrl_location() { 
		return url_location;
	}
	
//I create setters	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPost_date(String PublishedAt) {
		this.post_date = PublishedAt;
	}

	public void setUrl_location(String Url) {
		this.url_location = Url;
	}
	
//I make Override toString in order to return the results 	
	@Override
    public String toString() {
        return "NewsInfo{" +
                "title='" + title + "'\n" +
                ", description='" + description + "'\n" +
                ", post_date='" + post_date + "'\n" +
                ", url_location='" + url_location + "'\n" +
                '}';
    }
	
	
}
