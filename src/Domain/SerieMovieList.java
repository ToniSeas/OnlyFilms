package Domain;

import Domain.TDAListas.DoubleLinkedList;
import Domain.TDAListas.Nodo;

public class SerieMovieList {

	private DoubleLinkedList serieMovieList;
	
	public SerieMovieList() {
		this.serieMovieList = new DoubleLinkedList();
	} // Fin del constructor
	
	public void addContent (AudioVisualContent content) {
		int userAge = SingletonUserAccountUse.getIntance().getUserAccount().getProfileInUse().getAgeProfile();
		if (content.getRecommendedAge() <= userAge) {
			this.serieMovieList.insert(content);
		} // if
	} // Fin de addContent

	public AudioVisualContent getContentByPosition (int position) {
		return (AudioVisualContent)this.serieMovieList.getByPosition(position);
	} // Fin de getContentByPosition

	public Nodo getFirstContent () {
		return this.serieMovieList.getStart();
	} // Fin de getFirstCategory
	
	public DoubleLinkedList getSerieMovieList() {
		return serieMovieList;
	}

	public void setSerieMovieList(DoubleLinkedList serieMovieList) {
		this.serieMovieList = serieMovieList;
	}
	
	public int getSize () {
		return this.serieMovieList.getSize();
	} // Fin de getSize
	
} // Fin de clase
