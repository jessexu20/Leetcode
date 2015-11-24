import java.util.*;
public class MorseCode{
	char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
	            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
	            'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8',
	            '9', '0'};
	String[] dottie = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
	            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
	            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
	            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
	            "-....", "--...", "---..", "----.", "-----" };
	HashMap <Character,String> map;
	HashMap <String,Character> reverseMap;
	MorseCode(){
		map = new HashMap<Character,String>();
		reverseMap = new HashMap <String,Character>();
		for(int i = 0; i < alpha.length;i++){
			map.put(alpha[i],dottie[i]);
			reverseMap.put(dottie[i],alpha[i]);
		}
	}
	public String strToMorse(String str){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length();i++){
			sb.append(map.get(str.charAt(i)));
		}
		return sb.toString();
	}
	public List<String> morseToStr(String str){
		List<String> result = new ArrayList();
		helper(result,"",str);
		return result;
	}
	public void helper(List<String> result, String temp, String str){
		if(str.length()<1){
			result.add(temp);
			return;
		}
		for(int i = 1; i <= str.length(); i++){
			String left = str.substring(0,i);
			if(reverseMap.containsKey(left)){
				helper(result,temp+reverseMap.get(left),str.substring(i));
			}
		}
	}
	public static void main(String args[]){
		MorseCode morse = new MorseCode();
		List<String> m = new ArrayList(morse.morseToStr("...---..."));
		for(String s : m){
			System.out.println(morse.strToMorse(s));
		}
	}
}