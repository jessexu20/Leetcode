package filesystem;

public class File extends Entry{
	private String contentString;
	private int size;
	public File(String n, Directory d,int s) {
		super(n, d);
		d.addEntry(this);
		size=s;
		// TODO Auto-generated constructor stub
	}
	public String getContentString() {
		return contentString;
	}
	public void setContentString(String contentString) {
		this.contentString = contentString;
	}
	public int size() {
		return size;
	}


}
