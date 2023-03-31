package Domain;

import java.io.Serializable;
import Domain.CategoryGraph.CategoryGraph;

public class Profile implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nameProfile; 
	private int ageProfile; 
	private String genderProfile; 
	private String accountRegion;
	private CategoryGraph categoryGraph;
	private VisualizationPriority visualizationP;
	
	public Profile(String nameProfile, int ageProfile, String genderProfile, String accountRegion) {  
		
		this.nameProfile = nameProfile;
		this.ageProfile = ageProfile;
		this.genderProfile = genderProfile;
		this.accountRegion = accountRegion;
		this.categoryGraph = new CategoryGraph();
		this.visualizationP=new VisualizationPriority();
				
	} // Fin del constructor 
	
	public String getNameProfile() {
		return nameProfile;
	} // Finde  getNameProfile
	
	public int getAgeProfile() {
		return ageProfile;
	} // Fin de getAgeProfile
	
	public String getGenderProfile() {
		return genderProfile;
	} // Fin de getGenderProfile
	
	public String getAccountRegion() {
		return accountRegion;
	} // Fin de getAccountRegion

	public CategoryGraph getCategoryGraph() {
		return categoryGraph;
	}

	public void setCategoryGraph(CategoryGraph categoryGraph) {
		this.categoryGraph = categoryGraph;
	}

	public VisualizationPriority getVisualizationP() {
		return visualizationP;
	}

	public void setVisualizationP(VisualizationPriority visualizationP) {
		this.visualizationP = visualizationP;
	}

	public void setNameProfile(String nameProfile) {
		this.nameProfile = nameProfile;
	}

	public void setAgeProfile(int ageProfile) {
		this.ageProfile = ageProfile;
	}

	public void setGenderProfile(String genderProfile) {
		this.genderProfile = genderProfile;
	}

	public void setAccountRegion(String accountRegion) {
		this.accountRegion = accountRegion;
	}
	
	
}//fin de clase 