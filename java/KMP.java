public class KMP {
    public int strStr(String haystack, String needle) {
		if(needle.equals("")) return 0;
		if(needle.length()>haystack.length() || haystack.equals("")) return -1;
        int j =0;
        int [] pos= new int [needle.length()];
        pos[0]=0;
        for(int i=1;i<needle.length();i++){
            if(needle.charAt(i)==needle.charAt(j)){
                pos[i]=++j;
            }
            else{
                pos[i]=0;
                j=0;
            }
        }
		int i=0;j=0;
        while(i<haystack.length()){
			System.out.println(j+"\t"+haystack.charAt(i));
            if(haystack.charAt(i)==needle.charAt(j)){
                j++;
				i++;
                if(j==needle.length())
                    return i-j;
            }
            else{
                while(j!=0 && haystack.charAt(i)!=needle.charAt(j))
                    j=pos[j-1];
				if(j==0 && haystack.charAt(i)!=needle.charAt(j)) i++;
            }
        }
        return -1;
    }
	public static void main(String args[]){
		KMP kmp=new KMP();
		System.out.println(kmp.strStr("mississippi","issip"));
	}
}