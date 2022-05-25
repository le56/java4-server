package Service;

public class AccountService{
	
	public static boolean checkAccount(String accountName, String pass) {
		String name = "duong";
		String pass1 = "123";
		
		if(accountName.equals(name)==true && pass.equals(pass1)==true) {
			return true;
		}
		
		return false;
	}
}
