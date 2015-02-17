package filesystem;

import java.util.ArrayList;

public class Directory extends Entry{
	protected ArrayList<Entry>contents;
	public Directory(String n, Directory d) {
		super(n, d);
		// TODO Auto-generated constructor stub
		contents=new ArrayList<Entry>();
	}
	public int size(){
		int count=0;
		for (Entry entry : contents) {
			count+=entry.size();
		}
		return count;
	}
	public int numberOfFiles(){
		int count =0;
		for (Entry entry : contents) {
			if (entry instanceof Directory) {
				count++;
				Directory d = (Directory) entry;
				count+=d.numberOfFiles();
			}
			else if (entry instanceof File) {
				count++;
			}
		}
		return count;
	}
	public boolean deleteEntry(Entry entry) {
		// TODO Auto-generated method stub
		return contents.remove(entry);
	}
	public void addEntry(Entry entry){
		contents.add(entry);
	}
	protected ArrayList<Entry> getcontents(){
		return contents;
	}

}
