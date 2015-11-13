public class StringCompare{
	// public String [] findString(String [] strs){
	//
	//
	// }
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
	}
	public static void main(String args[]){
		StringCompare sc = new StringCompare();
		System.out.println(sc.convert("a"));
	}
}
