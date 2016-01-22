import java.util.List;
import java.util.ArrayList;
public class StringSplit{
	public List<String> split(String str,char ch){
		List list=new ArrayList<String> ();
		String temp="";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!=ch){
				temp+=str.charAt(i);
			}
			else{
				if(temp!="")
					list.add(temp);
				temp="";
			}
		}
		return list;
	}
	public static void main(String args[]){
		StringSplit ss= new StringSplit();
		String str="abc.fsa.d.s.s..sd.s.d";
		System.out.println(ss.split(str,'.'));
	}
}