public class SortString{
	public String sort(String str1, String str2){
		String [] strs1 = str1.split(" ");
		String [] strs2 = str2.split(" ");
		return merge(strs1,strs2);
	}
	public String merge(String [] str1, String[] str2){
		int i = 0, j= 0;
		StringBuilder str = new StringBuilder();
		while(i < str1.length || j <str2.length){
			if(i == str1.length){
				str.append(str2[j++]+" ");
			}
			else if(j == str2.length){
				str.append(str1[i++]+" ");
			}
			else{
				if(str1[i].compareTo(str2[j])<0)
					str.append(str1[i++]+" ");
				else str.append(str2[j++]+" ");
			}
		}
		return str.toString().substring(0,str.toString().length()-1);
	}
	public static void main(String args[]){
		SortString ss = new SortString();
		System.out.println(ss.sort("abcd e qrs","g z"));
	}
}