import java.util.*;
import java.lang.*;
public class LetterPhone{
	public void traverse(HashMap<Character,String> map,int index,List<String> strList,String str,int digitLen,String digits){
		if(index==digitLen){
			strList.add(str);
			return;
		}	
		String choice= map.get(digits.charAt(index));
		for(int i=0;i<choice.length();i++){
			str+=choice.charAt(i);
			String temp= str;
			traverse(map,index+1,strList,temp,digitLen,digits);
			str=str.substring(0,str.length()-1);
		}
	}
	public List<String> letterCombinations(String digits) {
		HashMap<Character,String> map= new HashMap();
		List<String> strList= new ArrayList();
		map.put('2',"abc");map.put('3',"def");map.put('4',"ghi");
		map.put('5',"jkl");map.put('6',"mno");map.put('7',"pqrs");
		map.put('8',"tuv");map.put('9',"wxyz");
		int digitLen=digits.length();
		traverse(map,0,strList,"",digitLen,digits);
		return strList;
	}
	public static void main(String args[]){
		LetterPhone lp=new LetterPhone();
		String digit="23";
		System.out.println(lp.letterCombinations(digit));
	}
}