import java.util.HashMap;
public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
			return false;
		HashMap <Character,Character> map=new HashMap();
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(map.containsKey(ch)){
				if(t.charAt(i)!=map.get(ch))
					return false;
			}
			else{
				if(map.values().contains(t.charAt(i)))
					return false;
				map.put(ch,t.charAt(i));
			}
		}
		return true;
    }
	public static void main(String args[]){
		Isomorphic iso=new Isomorphic();
		String a="ab";
		String b="aa";
		System.out.println(iso.isIsomorphic(a,b));
	}
}