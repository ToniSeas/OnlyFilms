package Domain;

import java.io.InputStream;
import java.io.Serializable;

import javafx.scene.image.Image;

public class AudioVisualContent implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String gender;
	private int recommendedAge;
	private String synopsis;
	private int durationMinutes;
	private InputStream coverImage;
	private Image image;
	private String directorName;
	private String contentType;
	private int yearIssue;
	
	public AudioVisualContent(String name, String gender, int recommendedAge, String synopsis, int durationMinutes,
			String pathImage, String directorName, String contentType, int yearIssue) {
		this.name = name;
		this.gender = gender;
		this.recommendedAge = recommendedAge;
		this.synopsis = synopsis;
		this.durationMinutes = durationMinutes;

		this.coverImage = getClass().getResourceAsStream(pathImage);
		image=new Image(coverImage);

		this.directorName = directorName;
		this.contentType = contentType;
		this.yearIssue = yearIssue;
	} // Fin del constructor
	
//----------------------------------------getters----------------------------------------
	public String getName() {return name;}
	public int getRecommendedAge() {return recommendedAge;}
	public String getSynopsis() {return synopsis;}
	public int getDurationMinutes() {return durationMinutes;}
	public Image getCoverImage() {return image;}
	public String getDirectorName() {return directorName;}
	public String getContentType() {return contentType;}
	public int getYearIssue() {return yearIssue;}

	
//----------------------------------------setters----------------------------------------	
	public void setName(String name) {this.name = name;}
	public void setRecommendedAge(int ageRestriction) {this.recommendedAge = ageRestriction;}
	public void setSynopsis(String synopsis) {this.synopsis = synopsis;}
	public void setDurationMinutes(int duration) {this.durationMinutes = duration;}
	public void setCoverImage(Image image) {this.image = image;}
	public void setDirectorName(String directorName) {this.directorName = directorName;}
	public void setContentType(String contentType) {this.contentType = contentType;}
	public void setYearIssue(int yearIssue) {this.yearIssue = yearIssue;}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setCoverImage(InputStream coverImage) {
		this.coverImage = coverImage;
	}
	
}//Fin del main
