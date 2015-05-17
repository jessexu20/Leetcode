package booksystem;

public enum AccountType {
	User(0),Librarian(1),Admin(2);
	private int value;
	AccountType(int v) {
		// TODO Auto-generated constructor stub
		value=v;
	}
}
