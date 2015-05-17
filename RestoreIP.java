import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuffer;
public class RestoreIP{
	public boolean checkValid(String s){
		if(s.length()>1 && s.charAt(0)=='0')
			return false;
		if(s.length()==3){
			if(s.charAt(0)>'2')
				return false;
			if(s.charAt(0)=='2'){
				if(s.charAt(1)>'5')
					return false;
				else if(s.charAt(1)=='5' && s.charAt(2)>'5')
					return false;
				else return true;	
			}
			return true;
		}
		return true;
	}
    public List<String> restoreIpAddresses(String s) {
		if(s.length()>12)
			return new ArrayList();
		List<String> list=new ArrayList();
        if(s.length()==12){
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<12;i+=3){
				String t=s.substring(i,i+3);
				if(checkValid(t))
					sb.append(t+".");
				else return new ArrayList();	
			}
			sb.deleteCharAt(sb.length()-1);
			list.add(sb.toString());
			return list;
		}
		int l,m,r;
		for(l=1;l<=Math.min(3,s.length());l++){
			if(l+9<s.length())
				continue;
			for(m=l+1;m<Math.min(l+4,s.length());m++){
				if(m+6<s.length())
					continue;
				for(r=m+1;r<Math.min(m+4,s.length());r++){
					if(r+3<s.length())
						continue;
					// System.out.print("l="+l);
					// System.out.print("m="+m);
					// System.out.println("r="+r);
					if(checkValid(s.substring(0,l))&&checkValid(s.substring(l,m))&&checkValid(s.substring(m,r))&&checkValid(s.substring(r,s.length()))){
						list.add(s.substring(0,l)+"."+s.substring(l,m)+"."+s.substring(m,r)+"."+s.substring(r,s.length()));
					}
						
				}
			}
		}
		return list;
    }
	public static void main(String args[]){
		RestoreIP ip= new RestoreIP();
		String str="010010";
		List<String> list=ip.restoreIpAddresses(str);
		System.out.println(list);
	}
}