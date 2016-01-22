import java.util.*;
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
		ArrayList<String> result= new ArrayList<>();
        ArrayList<String> row= new ArrayList<>();
		int wl=0;
		for(String str:words){
			if((wl+str.length()+row.size())>maxWidth){//each words should be within at least one space
				result.add(format(row,maxWidth,false,wl));
				row.clear();
				wl=str.length();
				row.add(str);
			}
			else{
				wl+=str.length();
				row.add(str);
			}
			// System.out.println(row+"\t"+wl);
		}
		// System.out.println(row+"\t"+wl);
		result.add(format(row,maxWidth,true,wl));
		return result;
    }
	
	public String format(List<String> words,int maxWidth,boolean last,int wl){
		String res="";
		if(last||words.size()==1){
			for(String str:words){
				res+=(str+" ");
			}
			res=res.substring(0,res.length()-1);
			while(res.length()<maxWidth){
				res+=" ";
			}
			return res;
		}
		int space=maxWidth-wl;//count the space for each row
		int len=words.size();//num of words
		int divBy=len-1;//space should be 1 less than the words
		while(divBy>0){
			int div=space/divBy;
			res=words.get(--len)+res;
			int count=div;
			while(count>0){
				res=" "+res;
				space--;
				count--;
			}
			divBy--;	
		}
		res=words.get(--len)+res;
		return res;	
	}
	public static void main(String args[]){
		String [] w= {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
		TextJustification tj=new TextJustification();
		List<String> res=(tj.fullJustify(w,30));
		for(String s:res){
			System.out.println(s);
		}
	}
}