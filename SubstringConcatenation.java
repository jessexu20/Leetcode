import java.util.*;
public class SubstringConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		HashMap<String,Integer> tmap=new HashMap<String,Integer>();
		int wl=0;
		if(words.length==0){
			return new ArrayList();
		}
		else wl=words[0].length();
		for(String str: words){
			if(map.containsKey(str)) map.put(str,map.get(str)+1);
			else map.put(str,1);
		}
		List<Integer> result= new ArrayList();
		for(int i=0;i<wl;i++){
			int left=i,count=0;tmap.clear();
			System.out.println(left);
			for(int j=i;j+wl<=s.length();j+=wl){
				String temp=s.substring(j,j+wl);
				if(map.containsKey(temp)){
					if (tmap.containsKey(temp)) tmap.put(temp,tmap.get(temp)+1);
					else tmap.put(temp,1);
					if(tmap.get(temp)<=map.get(temp)){
						count++;
					}else{
						while(tmap.get(temp)>map.get(temp)){
							String str=s.substring(left,left+wl);
							tmap.put(str,tmap.get(str)-1);
							if(tmap.get(str)<map.get(str))
								count--;
							left+=wl;
						}
					}
					if(count==words.length){
						result.add(left);
						String t= s.substring(left,left+wl);
						tmap.put(t,tmap.get(t)-1);
						count--;
						left+=wl;
					}
				}else{
					tmap.clear();
					count=0;
					left=j+wl;
				}
			}
		}
		return result;
    }
	public static void main(String args[]){
		SubstringConcatenation sc= new SubstringConcatenation();
		String str="aaaaaaaa";
		String [] words={"aa", "aa","aa"};
		System.out.println(sc.findSubstring(str,words));
	} 
}