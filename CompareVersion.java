import java.util.*;
public class CompareVersion{
	public boolean allZeros(String str){
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!='0')
				return false;
		}
		return true;
	}
	public ArrayList<String> splitDot(String str){
		ArrayList<String> res=new ArrayList();
		int i,j=0;
		for(i=0;i<str.length();i++){
			if(str.charAt(i)=='.'){
				res.add(str.substring(j,i));
				j=i+1;
			}
		}
		res.add(str.substring(j,i));
		return res;
	}
	public int stringCompare(String v1,String v2){
		int l1=v1.length();
		int l2=v2.length();
		while(l1!=l2){
			if(l1>l2){
				v2="0"+v2;
				l2++;
			}
			else if(l1<l2){
				v1="0"+v1;
				l1++;
			}
		}
		if(v1.equals(v2)) return 0;
		int len=v1.length();
		for(int i=0;i<len;i++){
			if(v1.charAt(i)!=v2.charAt(i)){
				if(v1.charAt(i)>v2.charAt(i)){
					return 1;
				}
				else return -1;
			}
		}
		return 0;
	}
	public int compareVersion(String version1, String version2){
		ArrayList<String> v1=splitDot(version1);
		ArrayList<String> v2=splitDot(version2);
		int minLen= v1.size()<v2.size()? v1.size():v2.size();
		int i=0;
		while(i<minLen){
			if(stringCompare(v1.get(i),v2.get(i))==1)
				return 1;
			else if (stringCompare(v1.get(i),v2.get(i))==-1)
				return -1;
			else{
				i++;
			}
		}
		if(v1.size()<v2.size()){
			if(!allZeros(v2.get(i))) return -1;
			i++;
		}
		if(v1.size()>v2.size()){
			if(!allZeros(v1.get(i))) return 1;
			i++;
		}
		return 0;
	}
	public static void main(String args[]){
		String v1="1.0";
		String v2="1";
		CompareVersion cv=new CompareVersion();
		System.out.println(cv.compareVersion(v1,v2));
	}
}