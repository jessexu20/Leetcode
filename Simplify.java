import java.util.HashMap;
public class Simplify{
	public boolean isLetter(char x){
		if((x>='a' && x<='z') || (x>='A' && x<='Z') || x=='/'|| x=='@') {
			return true;
		}
		else return false;
	}
	public String replacedot(String path){
		return path.replaceAll("...", "@");
	}
	public String simplifyPath(String path){
		path=replacedot(path);
		System.out.println(path);
		int len=path.length();
		int i = len-1;
		while(path.charAt(i)=='/' && i>0){
			i--;
		}
		int j=i;
		while(isLetter(path.charAt(j))&& j>0)
			j--;
		String result=null;
		if(j>0)	
			result=path.substring(j+1,i+1);
		else result=path.substring(j,i+1);
		i=0;
		HashMap hashmap= new HashMap();
		while(i<result.length()-1){
			if((result.charAt(i)==result.charAt(i+1)) && result.charAt(i)=='/'){
				hashmap.put(i,1);
			}
			i++;
		}
		j=0;
		String finalString="";
		i=0;
		while(i<result.length()){
			if(!hashmap.containsKey(i)){
				if(result.charAt(i)!='@')
					finalString+=result.charAt(i);
				else finalString+="...";
				i++;
			}
			else{
				i++;
			}
		}
		return finalString;
	}
	public static void main(String args[]){
		String path="/...";
		Simplify simple=new Simplify();
		System.out.println(simple.simplifyPath(path));
	}
}