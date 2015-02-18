package booksystem;

public class OnlineReaderSystem {
	private Library library;
	private UserManager userManager;
	private Display display;
	private Book activeBook;
	private User activeUser;
	public OnlineReaderSystem() {
		// TODO Auto-generated constructor stub
		userManager=new UserManager();
		library=new Library();
		display=new Display();
	}
	public Book getActiveBook() {
		return activeBook;
	}
	public void setActiveBook(Book activeBook) {
		this.activeBook = activeBook;
		display.displayBook(activeBook);
	}
	public User getActiveUser() {
		return activeUser;
	}
	public void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
		display.displayUser(activeUser);
	}
	public Library getLibrary() {
		return library;
	}
	public UserManager getUserManager() {
		return userManager;
	}
	public Display getDisplay() {
		return display;
	}
	public void addBook(Book book){
		library.addBook(book.getId(),book.getDetails());
	}
	public void addUser(User user) {
		userManager.addUser(user.getId(),user.getDetails(),user.getAccountType());
	}
	
}
