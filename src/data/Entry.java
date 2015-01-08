package data;

import java.sql.Timestamp;

public class Entry {
	public static final String ATTRIBUTE_NAME = "entry";
	private Integer ID;
	private String username;
	private Timestamp submissionDate;
	private String movieName;
	private String entryType;
	
	public Entry(String username, Timestamp submissionDate, String movieName, String entryType) {
		this.username = username;
		this.submissionDate = submissionDate;
		this.movieName = movieName;
		this.entryType = entryType;
	}
	
	public Entry(Integer ID, String username, Timestamp submissionDate, String movieName, String entryType) {
		this.ID = ID;
		this.username = username;
		this.submissionDate = submissionDate;
		this.movieName = movieName;
		this.entryType = entryType;
	}
	
	
	public Integer getID() {
		return ID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public Timestamp getSubmissionDate() {
		return submissionDate;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public String getEntryType() {
		return entryType;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("ID: " + ID + "; ");
		result.append("Username: " + username + "; ");
		result.append("SubmissionDate: " + submissionDate + "; ");
		result.append("movieName: " + movieName + "; ");
		result.append("entryType: " + entryType + "; ");
		return result.toString();
	}
}













