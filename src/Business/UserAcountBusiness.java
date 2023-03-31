package Business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import Data.UserAcountData;
import Domain.UserAccount;

public class UserAcountBusiness {
	
	private UserAcountData userAccountData; 
	
	 public UserAcountBusiness() throws IOException {
		this.userAccountData= new UserAcountData(); 
	 } // Fin del constructor
	
	 public List<UserAccount> readUserAccount() throws FileNotFoundException, IOException, ClassNotFoundException {
		 return this.userAccountData.readUsersAccount(); 
	 } // Fin de readUserAccount
	 
	 public void registerAccount(UserAccount userAccount) throws FileNotFoundException, IOException, ClassNotFoundException {
		 
		 this.userAccountData.registerAccount(userAccount);
	 } // Fin de registerAccount
	 public boolean registerAccountNotEquals(UserAccount userAccount) throws FileNotFoundException, IOException, ClassNotFoundException {
		 
			List<UserAccount> users = this.readUserAccount(); 
			if (users!=null) {
				for (int i = 0; i < users.size(); i++) {
					if (userAccount.getUserName().equals(users.get(i).getUserName())) {
						return false; 
					} // Fin de if 
				} // Fin de for
			} // Fin de if
			this.registerAccount(userAccount);
			return true; 
	} // Fin de registerAccountNotEquals
	 public UserAccount getUserAccount (String nameAccount, String password) throws FileNotFoundException, IOException, ClassNotFoundException {
		 return this.userAccountData.getUserAccount(nameAccount, password); 
	 } // Fin de getUserAccount
	 public void upDateAccount (UserAccount userUpDate) throws FileNotFoundException, IOException, ClassNotFoundException {
		 this.userAccountData.upDateAccount(userUpDate);
	 }
} // Fin de clase 
