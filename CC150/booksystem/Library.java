package booksystem;

import java.util.Hashtable;

public class Library {
	private Hashtable<Integer, Book> books;
	public Library() {
		// TODO Auto-generated constructor stub
		books=new Hashtable<>();
	}
	public Book addBook(int id,String details) {
		if (books.containsKey(id)) {
			return null;
		}
		Book book=new Book(id,details);
		books.put(id, book);
		return book;
	}
	public boolean remove(Book b){
		return remove(b.getId());
	}
	private boolean remove(int id) {
		// TODO Auto-generated method stub
		if (!books.containsKey(id)) {
			return false;
		}
		books.remove(id);
		return true;
	}
	public Book findBook(int id) {
		return books.get(id);
	}
}
