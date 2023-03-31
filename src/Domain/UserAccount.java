package Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class UserAccount implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	private String userName; 
	private String password; 
	private String cardNumber; 
	private String accountRegion;
	private Profile defaultProfile; 
	private Profile profileInUse; 
	private ArrayList<Profile> profiles;
	
	public UserAccount(String userName, String password, String cardNumber, String accountRegion) {
		super();
		this.userName = userName;
		this.password = password;
		this.cardNumber = cardNumber;
		this.accountRegion = accountRegion;
		this.profiles= new ArrayList<>();
		this.defaultProfile =   new Profile(this.userName, 18, "NO binario", this.accountRegion);
		this.profileInUse=this.defaultProfile; 
	} // Fin del constructor
		
	public boolean addProfile(Profile profile) {
		if (profile.getAgeProfile()<=0||profile.getAgeProfile()>122) {
			return false; 
		}
		if (this.defaultProfile.getNameProfile().equals(profile.getNameProfile())) {
			return false; 
		}
		for (int i = 0; i < profiles.size(); i++) {
			if (this.profiles.get(i).getNameProfile().equals(profile.getNameProfile())) {
				return false; 
			}
		}
		this.profiles.add(profile);
		return true; 
	} // Fin de agregarAddProfile
	public boolean validateNameProfile(Profile profile) {
		for (int i = 0; i < profiles.size(); i++) {
			if (this.profiles.get(i).getNameProfile().equals(profile.getNameProfile())) {
				return true; 
			}
		}
		return false; 
	} // Fin de validateNameProfile
	public boolean validateAge(Profile profile) {
		if (profile.getAgeProfile()<=0||profile.getAgeProfile()>122) {
			return true; 
		}
		return false; 
	} // Fin de validateAge
	public Profile getProfile(int i) {
		return this.profiles.get(i);  
	} // Fin de getProfile
	public void selectProfile(String nameProfile) {
		for (int i = 0; i <this.profiles.size(); i++) {
			if (this.profiles.get(i).getNameProfile().equals(nameProfile)) {
				this.profileInUse=this.profiles.get(i); 
				break; 
			}else this.profileInUse=defaultProfile; 
		}
		
	} // Fin de seleccionar 
	public int sizeProfiles() {
		return this.profiles.size(); 
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public String getAccountRegion() {
		return accountRegion;
	}
	public Profile getDefaultProfile() {
		return defaultProfile;
	}

	public void setDefaultProfile(Profile defaultProfile) {
		this.defaultProfile = defaultProfile;
	}

	public Profile getProfileInUse() {
		return profileInUse;
	}

} // Fin de clase 
