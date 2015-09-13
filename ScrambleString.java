public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        int [] chars= new int [26];
 	    if (s1.equals(s2)) return true;
		if(s1.length()!=s2.length())
			return false;
		for(int i=0;i<s1.length();i++){
			chars[s1.charAt(i)-'a']++;
			chars[s2.charAt(i)-'a']--;
		}
		for(int i=0;i<chars.length;i++){
			if(chars[i]!=0) return false;
		}
		for(int i=1;i<s1.length();i++){
			if(isScramble(s1.substring(0,i),s2.substring(0,i))
				&&isScramble(s1.substring(i),s2.substring(i)))
				return true;
			if(isScramble(s1.substring(0,i),s2.substring(s1.length()-i))
				&&isScramble(s1.substring(i),s2.substring(0,s1.length()-i)))
				return true;
		}
		return false;
    }
	public static void main(String args[]){
		ScrambleString ss= new ScrambleString();
		String s1="rgtae";
		String s2="great";
		System.out.println(ss.isScramble(s1,s2));
	}
}