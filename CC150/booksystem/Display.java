package booksystem;

public class Display {
	private Book activeBook;
	private User activeUser;
	private int pageNumber=0;
	public void displayBook(Book activeBook) {
		// TODO Auto-generated method stub
		pageNumber=0;
		this.activeBook=activeBook;
		refreshTitle();
		refreshDetails();
		refreshPage();
	}

	private void refreshPage() {
		// TODO Auto-generated method stub
		
	}

	private void refreshDetails() {
		// TODO Auto-generated method stub
		
	}

	private void refreshTitle() {
		// TODO Auto-generated method stub
		
	}

	public void displayUser(User activeUser) {
		// TODO Auto-generated method stub
		this.activeUser=activeUser;
		refreshUsername();
	}

	private void refreshUsername() {
		// TODO Auto-generated method stub
		
	}
	public void turnPageForward(){
		pageNumber++;
		refreshPage();
	}
	public void turnPageBackward(){
		pageNumber--;
		refreshPage();
	}

}
