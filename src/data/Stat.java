package data;

public class Stat {
	public static final String ATTRIBUTE_NAME = "stat";
	private String movieName;
	private Integer seansebi;
	private Integer javshnebi;
	private Integer sxva;
	
	public Stat(String movieName, Integer seansebi, Integer javshnebi, Integer sxva) {
		this.movieName = movieName;
		this.seansebi = seansebi;
		this.javshnebi = javshnebi;
		this.sxva = sxva;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public Integer getSeansebi() {
		return seansebi;
	}
	
	public Integer getJavshnebi() {
		return javshnebi;
	}
	
	public Integer getSxva() {
		return sxva;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("seansebi: " + seansebi + "; ");
		result.append("javshnebi: " + javshnebi + "; ");
		result.append("sxva: " + sxva + "; ");
		return result.toString();
	}
}
