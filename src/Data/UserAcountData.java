package Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import Domain.UserAccount;
import Utility.ResourcesPath;

public class UserAcountData {
	private String ruta;
	
	public UserAcountData() throws IOException {
		this.ruta = ResourcesPath.RUTARCHIVO;//nombre que tendrá nuestro archivo con la informacion de las cuentas
	} // Fin del constructor

   //metodo que agrega las cuentas 
	public void registerAccount(UserAccount userAccount) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(this.ruta);//crea el archivo con la ruta anterior
		//List de java.util
		List<UserAccount> accounts= new ArrayList<UserAccount>();
		if (file.exists()) {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			Object aux = input.readObject();
			accounts = ((List<UserAccount>)aux);
			input.close();
		} // Fin de if
		accounts.add(userAccount);
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
		output.writeUnshared(accounts);
	} // Fin de registerAccount 
	
	//metodo que retono un list con todos los datos del archivo 
	public List<UserAccount> readUsersAccount () throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(this.ruta);
		List<UserAccount> accounts = new ArrayList<UserAccount>();
		if (file.exists()) {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			Object aux = input.readObject();
			accounts = ((List<UserAccount>)aux);
			input.close();
			return accounts;
		} // Fin de if
		return null;
	} // Fin de readUsersAccount 
	//usando el metodo readUsersAccount donde guarda las cuentas del archivo 
	//este metodo retornará comparndo con el nombre y comtraseña la cuneta deseada en el iniciar sesión
	public UserAccount getUserAccount (String nameAccount, String password) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		List<UserAccount> accounts = this.readUsersAccount();
		if (accounts==null) {
			return null; 
		} // Fin de if
		for (int i = 0; i < accounts.size(); i++) {
			if (nameAccount.equals(accounts.get(i).getUserName())&&password.equals(accounts.get(i).getPassword())) {
				return accounts.get(i); 
			} // Fin de is
		} // Fin de for-i
	
		return null;
	} // Fin de getUserAccount 

	public void upDateAccount (UserAccount userUpDate) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(this.ruta);//crea el archivo con la ruta anterior
		//List de java.util
		List<UserAccount> accounts = new ArrayList<UserAccount>();
		if (file.exists()) {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			Object aux = input.readObject();
			accounts = ((List<UserAccount>)aux);
			input.close();
		} // Fin de if
		System.out.println(accounts.size());
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getUserName().equals(userUpDate.getUserName()) && accounts.get(i).getPassword().equals(userUpDate.getPassword())) {
				accounts.remove(i);
				accounts.add(userUpDate);
				break;
			} // Fin de if
		} // Fin de for-i
		//accounts.add(userAccount);
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
		output.writeUnshared(accounts);
				
	} // Fin de upDateAccount
	
} // Fin de clase 
