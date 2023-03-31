package Domain;

public class SingletonUserAccountUse {
	
	private static SingletonUserAccountUse singletonUserAccountUse;//modelo Singleton
	private UserAccount userAccount; //creacion de la variable de cuenta
	
	private SingletonUserAccountUse  () {
		this.userAccount = null; 
	} // Fin del constructor
	
	public static SingletonUserAccountUse getIntance() {
		
		if(singletonUserAccountUse == null) {//si el objeto singleton esta vacio lo crea
			singletonUserAccountUse = new SingletonUserAccountUse();
		} // if
		return singletonUserAccountUse;
		
	} // Fin de getIntance
	
	public void addUserAccount (UserAccount userAccount) {
		this.userAccount = userAccount;
	} // Fin de addUserAccount

	public static SingletonUserAccountUse getSingletonUserAccountUse() {
		return singletonUserAccountUse;
	}//fin de SingletonUserAccountUse

	public static void setSingletonUserAccountUse(SingletonUserAccountUse userAccountUse) {
		SingletonUserAccountUse.singletonUserAccountUse = userAccountUse;
	}//fin de setSingletonUserAccountUse

	public UserAccount getUserAccount() {
		return userAccount;
	}//fin de  getUserAccount

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}//fin de setUserAccount 
	
} // Fin de clase
