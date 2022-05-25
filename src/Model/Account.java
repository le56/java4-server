package Model;

public class Account {
	private String nameAccount;
	private String password;
	
	public Account(String nameAccount, String password) {
		super();
		this.nameAccount = nameAccount;
		this.password = password;
	}
	
	public String getNameAccount() {
		return nameAccount;
	}
	public void setNameAccount(String nameAccount) {
		this.nameAccount = nameAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
