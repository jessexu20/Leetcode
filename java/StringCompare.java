import java.util.*;
public class StringCompare{
	public String [] findString(String [] strs){
		HashMap<String, Integer> map = new HashMap();
		String [] result = new String[2];
		for(String str: strs)
			map.put(str,convert(str));
		int product = 0;
		for(int i = 0; i < strs.length; i++){
			for(int j = i+1; j < strs.length;j++){
				if((map.get(strs[i]) & map.get(strs[j]))==0){
					if(strs[i].length()*strs[j].length()>product){
						product = strs[i].length()*strs[j].length();
						result[0] = strs[i];
						result[1] = strs[j]; 
					}
				}
			}
		}
		return result;
	}
	public int convert(String str){
		boolean [] chars = new boolean [26];
		for(int i = 0; i < str.length() ; i++){
			int index = str.charAt(i) - 'a';
			chars[index]=true;
		}
		int number = 0;
		for(int i = 0; i < 26; i++){
			number <<= 1;
			number += (chars[i]==true)?1:0;
		}
		return number;
	}
	public static void main(String args[]){
		StringCompare sc = new StringCompare();
		String [] strs = {"abc","faf","fda","def","de"};
		String [] result = sc.findString(strs);
		System.out.println(result[0]+"\t"+result[1]);
	}
}
