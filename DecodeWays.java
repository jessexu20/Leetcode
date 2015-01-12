import java.util.ArrayList;
public class DecodeWays{
	public boolean checkValid(char a, char b){
		if(a=='0')
			return false;
		else if(a=='1' && b<='9' && b>='0')
			return true;
		else if (a=='2' && b<='6' && b>='0')
			return true;
		else return false;
	}
    public int numDecodings(String s) {
		int len=s.length();
		if(len<1)
			return 0;
		if(s.charAt(0)=='0')
			return 0;
		if(len ==1 && s.charAt(0)!='0')
		    return 1;
		int[] res=new int[s.length()+1];
		res[0]=0;res[1]=1;
		if(s.charAt(0)=='1' && s.charAt(1)!='0')
			res[2]=2;
		else if(s.charAt(0)=='2' && s.charAt(1)<='6'&& s.charAt(1)>'0')
			res[2]=2;
		else if(s.charAt(1)=='0' && s.charAt(0)>'2')
			return 0;
		else res[2]=1;
		for(int i=2;i<s.length();i++){
			int count1=0;int count2=0;
			if(s.charAt(i)!='0')
				count1=res[i];
			if(checkValid(s.charAt(i-1),s.charAt(i)))
				count2=res[i-1];
			if(count1==0 && count2==0)
				return 0;
			else 
				res[i+1]=count1+count2;
		}
		for(int i:res)
			System.out.println(i);
		return res[res.length-1];
    }
	public static void main(String args[]){
		DecodeWays dw=new DecodeWays();
		String str="301";
		System.out.println(dw.numDecodings(str));
	}
}