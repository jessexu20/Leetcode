package google;

public class ReverseWordInString {
    public String reverseWords(String s) {
    	s.trim();
        StringBuilder temp =  new StringBuilder(s);
        StringBuilder str = new StringBuilder();
        temp.reverse();
        StringBuilder t = new StringBuilder();
        int i = 0,j=0;
        while(i<=j && j< s.length()){
            if(temp.charAt(j++)==' '){
                str = new StringBuilder(temp.substring(i,j-1));
                i=j;
                if(str.length()==0) continue;
				str.reverse();
                t.append(str);
                t.append(" ");
                
            }
        }
        str = new StringBuilder(temp.substring(i,j));
        str.reverse();
        t.append(str);
		return t.toString().trim();
    }
	public static void main(String args[]){
		ReverseWordInString rwis = new ReverseWordInString();
		System.out.println(rwis.reverseWords("                abcd ere f "));
	}
}