import java.util.*;
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String ret="";
        if(strs.size()<1) return ret;
        for(String s : strs){
            ret=ret+String.valueOf(s.length())+"/"+ s;
        }
        return ret;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int index=-1;
        List<String> recover= new ArrayList<String>();
        int prev=0;
        for(int i=-1; i < s.length() && (i=s.indexOf("/",i+1))>0 ;){
            int len=Integer.valueOf(s.substring(prev,i));
            recover.add(s.substring(i+1,i+1+len));
            i+=len;
            prev=i+1;
        } 
        return recover;
    }
	public static void main(String args[]){
		Codec codec = new Codec();
		List<String> list= new ArrayList<String>();
		list.add("fT,NH8E&E /$ny[Wq,");list.add("2/31/311");list.add("");
		String encoded=codec.encode(list);
		System.out.println(encoded);
		System.out.println(codec.decode(encoded));
		
	}
}

// Your Codec object will be instantiated and called as such:
