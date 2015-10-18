import java.util.*;
public class MinimumWindowSubstr {
    HashMap <Character,Integer> map =new HashMap();
    public boolean check(){
        for(Character c: map.keySet()){
            if(map.get(c)>0) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        for(int i=0;i<t.length();i++){
            char c =t.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else map.put(c,1);
        }
        String res="";
        int p=0,q=0,min=s.length()+1;
        while(q<s.length()){
            char c = s.charAt(q++);
            if(map.containsKey(c)) map.put(c,map.get(c)-1);//update map
            char d= s.charAt(p);
            while(p<q && p<s.length() && (!map.containsKey(d) || map.get(d)<0)){
                if(map.containsKey(d) && map.get(d)<0){
                    map.put(d,map.get(d)+1);//unuse the letter
                    
                }
                p++;
                if(p<s.length()) d= s.charAt(p);
                else break;
            }
            System.out.println(p+"\t"+q);
            System.out.println(map);
            if(check()){
				if(q-p<min){
	                min=Math.min(min,q-p);
	                res=s.substring(p,p+min);
				}
            } 
        }
        if(p+min>s.length()) return "";
        return res;
    }
	public static void main(String args[]){
		MinimumWindowSubstr mws= new MinimumWindowSubstr();
		System.out.println(mws.minWindow("cabwefgewcwaefgcf","cae"));
	}
}