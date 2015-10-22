import java.util.*;
public class EncodeString {
	int max=0;
    public String encode(String str) {
		String result = "";
		for(int i =1;i<str.length();i++){
			if(str.charAt(i)!=str.charAt(i-1)){
				if((str.charAt(i-1)<='9' && str.charAt(i-1)>='0')){
					result+=("1x"+str.charAt(i-1));
				}
				else
					result+=str.charAt(i-1);
			} 
			else{
				int count = 1;
				while(i<str.length() && str.charAt(i)==str.charAt(i-1)){
					count++;
					i++;
				}
				result+=String.valueOf(count)+"x"+str.charAt(i-1);
			}
		}
		if(result.charAt(result.length()-1)!=str.charAt(str.length()-1)) result+= str.charAt(str.length()-1);
		return result;
    }
	public String decode(String str){
		String result = "";
		for(int i = 0 ; i < str.length();i++){
			if(str.charAt(i)>'9' || str.charAt(i)<'0'){
				result+=str.charAt(i);
			}
			else{
				int j=i;
				while(str.charAt(j)<='9' && str.charAt(j)>='0'){
					j++;
				}
				int count =Integer.valueOf(str.substring(i,j));
				char c = str.charAt(j+1);
				while(count > 0){
					result+=c;
					count--;
				}
				i=j+1;
			}
		}
		return result;
	}
	public static void main(String args[]){
		EncodeString s= new EncodeString();
		String [] d={"ab13ccc","abc33333333333ddd","abcdeef","abcdef","ab"};
		for(int i = 0; i <d.length;i++){
			String en=s.encode(d[i]);
			System.out.println(en);
			System.out.println(s.decode(en));
		}
	}
}