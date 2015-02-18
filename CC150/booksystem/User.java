package booksystem;

public class User {
	int id;
	String details;
	AccountType accountType;
	public User(int id,String d,AccountType type) {
		this.id=id;
		this.details=d;
		this.accountType=type;
		// TODO Auto-generated constructor stub
	}
	public void renewMemberShip(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
}
