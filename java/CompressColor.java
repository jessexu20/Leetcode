import java.util.*;
public class CompressColor{
	public String compress(String str){
		StringBuilder result = new StringBuilder();
		for(int i = 0;i<str.length();i+=2){
			int o = strToHex(str.substring(i,i+2));
			char c = str.charAt(i);
			String str1= "", str2 ="", str3="";
			str1 += c;
			str1+=c;
			if(c!='F' && c != '9'){
				str2 += (char)(c+1);
				str2 += (char)(c+1);
			}
			else if(c =='9') str2 = "AA";
			if(c!='0' && c!='A'){
				str3 += (char)(c-1);
				str3 += (char)(c-1);
			}
			else if(c == 'A') str3 = "99";
			int num1 = strToHex(str1);
			int num2 = strToHex(str2);
			int num3 = strToHex(str3);
			if(o > num1){
				result.append(Math.abs(o-num1)<Math.abs(o-num2)?c:(char)(c+1));
			}
			else{
				result.append(Math.abs(o-num1)<Math.abs(o-num3)?c:(char)(c-1));
			}
		}
		return result.toString();
	}
	public int strToHex(String str){
		int []dic = {10,11,12,13,14,15};
		int num = 0;
		for(int i = 0;i<str.length();i++){
			if(str.charAt(i)<='9' && str.charAt(i)>='0'){
				num += (str.charAt(i)-'0');
			}
			else if(str.charAt(i)>='A'&& str.charAt(i)<='F'){
				num += dic[str.charAt(i)-'A'];
			}
			else return 0;
			num*=16;
		}
		return num;
	}
	public static void main(String args[]){
		CompressColor cc = new CompressColor();
		System.out.println(cc.compress("123456"));
	}
}