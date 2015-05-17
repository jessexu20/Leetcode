import java.lang.StringBuffer;
import java.lang.String;
import java.util.Arrays;
public class ArraysandStrings{
	public boolean unique(String str){//1.1
		int [] count = new int [52];
		for(int i=0;i<str.length();i++){
			if(count[str.charAt(i)-'A']>0)
				return false;
			else count[str.charAt(i)-'A']++;
		}
		return true;
	}
	public String reorder(String str){//1.3
		char [] charArray=str.toCharArray();
		Arrays.sort(charArray);
		String res=new String(charArray);
		return res;
	}
	public boolean compareS(String a,String b){//1.3
		String as=reorder(a);
		String bs=reorder(b);
		return as.equals(bs);
	}
	public String replaceS(String str){//1.4
		char [] charArray=str.toCharArray();
		String res="";
		for(char c:charArray){
			if(c==' ')
				res+="%20";
			else res+=c;
		}
		return res;
	}
	public String compressS(String str){//1.5
		int num=1;
		String strNew="";
		if(str.length()<2)
			return str;
		strNew+=str.charAt(0);
		for(int i=1;i<str.length();i++){
			if(str.charAt(i)==str.charAt(i-1))
				num++;
			else{
				strNew+=num;
				strNew+=str.charAt(i);
				num=1;
			}			
		}
		strNew+=num;
		// System.out.println(strNew);
		return str.length()>strNew.length()? strNew:str;
	}
	public boolean isSubString(String a,String b){//if a in b,return true//
		if(b.indexOf(a)!=-1) return true;
		else return false;
	}
	public boolean checkRotation(String a,String b){//1.8
		if(a.length()!=b.length())
			return false;
		String temp=b+b;
		System.out.println(temp);
		return isSubString(a,temp);
	}
	
	
	public static void main(String args[]){
		Unique u= new Unique();
		// System.out.println(u.compareS("abcAa","bcaAa"));
		// System.out.println(u.replaceS("Mr John Smith"));
		// System.out.println(u.compressS("aabbbb"));
		System.out.println(u.checkRotation("ba","ab"));
		
	}
}