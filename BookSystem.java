class Book{
	String author;
	String title;
	Book(String a, String t){
		this.author = a;
		this.title = t;
	}
}
class Reader{
	String name;
	int priority;
	Reader(String n, int p){
		this.name = n;
		this.priority = p;
	}
}
class Request{
	Reader reader;
	Book book;
	Request(Reader r, Book b){
		this.reader = r;
		this.book = b;
	}
}
public class BookSystem{
	HashMap<String, PriorityQueue<Reader>> reserve;//key: book title, value: que
	HashMap<String, Set<String>> wroteby;//key: author, value: list of book name
	BookSystem{
		reserve = new HashMap();
		wroteby = new HashMap();
	}
	public boolean addBook(Book b){
		if(!reserve.containsKey(b.title))
			reserve.add(b.title, new PriorityQueue<Reader>());
		else return false;
		if(!wroteby.containsKey(b.author)){
			Set<String> set = new HashSet();
			set.add(b.title);
			wroteby.put(b.author,set);
		}else{
			wroteby.get(b.author).add(b.title);
		}
		return true;
	}
	public boolean deleteBook(Book b){
		if(reserve.containsKey(b.title)){
			reserve.remove(b.title);
		}
		else return false;
		if(wroteby.containsKey(b.author)){
			wroteby.get(b.author).remove(b.title);
			if(wroteby.get(b.author).size()==0)
				wroteby.remove(b.author);
		}
		else return false
		return true;
	}
}