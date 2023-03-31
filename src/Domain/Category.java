package Domain;


import java.io.IOException;

import java.io.InputStream;

import javafx.scene.image.Image;

public class Category {

	private String gender;
	private InputStream imageLoader;
	private Image showImage;
 	private Image CoverImage;
	private Image CoverImageSelec;
	private int visitedCount;
	
	private SerieMovieList serieMovieList;
	
	public Category (String gender, String imagePath, String imageSelecPath, SerieMovieList serieMovieList) throws IOException {
		
		this.gender = gender;
		this.imageLoader = getClass().getResourceAsStream(imagePath);
		this.CoverImage=new Image(this.imageLoader);
		this.imageLoader = getClass().getResourceAsStream(imageSelecPath);
		this.CoverImageSelec = new Image(this.imageLoader);
		
		this.showImage = this.CoverImage;
		this.visitedCount = 0;
		
		this.serieMovieList = serieMovieList;

	} // Fin del constructor sobrecargado

	public SerieMovieList getSerieMovieList() {
		return serieMovieList;
	}

	public void setSerieMovieList(SerieMovieList serieMovieList) {
		this.serieMovieList = serieMovieList;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public InputStream getImageLoader() {
		return imageLoader;
	}

	public void setImageLoader(InputStream imageLoader) {
		this.imageLoader = imageLoader;
	}

	public Image getCoverImage() {
		this.showImage = this.CoverImage;
		return this.showImage;
	}

	public void setCoverImage(Image coverImage) {
		CoverImage = coverImage;
	}
	
	public Image getCoverImageSelec() {
		this.showImage = this.CoverImageSelec;
		return this.showImage;
	}

	public void setCoverImageSelec(Image coverImageSelec) {
		CoverImageSelec = coverImageSelec;
	}

	public Image getShowImage() {
		return showImage;
	}

	public void setShowImage(Image showImage) {
		this.showImage = showImage;
	}

	public int getVisitedCount() {
		return visitedCount;
	}

	public void setVisitedCount(int visitedCount) {
		this.visitedCount = visitedCount;
	}
	
} // Fin de clase
