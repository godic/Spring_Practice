package ioc;

public class Song {
	
	private String title;
	public Song() {
		this.title = "nonono";
	}
	public Song(String title) {
		this.title = title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
