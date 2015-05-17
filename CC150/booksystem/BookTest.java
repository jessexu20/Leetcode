package booksystem;

public class BookTest {
	public static void  main(String args[]) {
		OnlineReaderSystem ors=new OnlineReaderSystem();
		User user1=new User(1, "Jesse", AccountType.User);
		Book book1=new Book(1, "Algorithm");
		User user2=new User(2, "Jack", AccountType.Librarian);
		Book book2=new Book(2, "database");
		ors.addBook(book1);
		ors.addBook(book2);
		ors.addUser(user1);
		ors.addUser(user2);
		ors.setActiveUser(user1);
		ors.setActiveBook(book1);
	}
}
