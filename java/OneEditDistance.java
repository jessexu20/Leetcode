//Given two strings S and T, determine if they are both one edit distance apart.
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        // make sure s >= t
        if (s.length() < t.length())
            return isOneEditDistance(t, s);
        
        int diff = s.length() - t.length();  
        if (diff > 1)
            return false;
        
        // i - idx for s; j - idx for t; dis - previous difference
        int i = 0, j = 0, dis = 0;
        while (i < s.length() || j < t.length()) {
            // "aaa", "aa"
            if (j == t.length()) 
                return true;
            
            if (s.charAt(i++) == t.charAt(j++)) 
                continue;
            
            // found a different position, check if there is already one
            // if there is, return false;
            if (dis == 1)
                return false;
            
            dis++;
            // try to skip this character in s, set j back to previous position
            // "aba", "ba"
            if (diff == 1) j--;
        }
        
        // must be 1 instead of <= 1
        return dis == 1;
    }
	public static void main(String args[]){
		OneEditDistance one = new OneEditDistance();
		System.out.println(one.isOneEditDistance("a","ab"));
		System.out.println(one.isOneEditDistance("a","b"));
		System.out.println(one.isOneEditDistance("a","aba"));
		System.out.println(one.isOneEditDistance("ab","ba"));
		System.out.println(one.isOneEditDistance("a","a"));
	}
}