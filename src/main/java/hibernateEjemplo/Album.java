package hibernateEjemplo;

import java.util.*;

public class Album {
	private int id;
	private String title;
	private Date releasedate;
	
	public Album(){
		
	}
	
	public Album(int i, String t){
		this.id=i;
		this.title=t;
	}

	public int getId() {
		return id;
	}

	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
