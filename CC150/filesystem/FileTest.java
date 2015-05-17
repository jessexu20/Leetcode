package filesystem;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Directory d=new Directory("home", null);
		File file=new File("name", d, 5);
		System.out.println(d.size());
		d.deleteEntry(file);
		System.out.println(d.size());
	}

}
