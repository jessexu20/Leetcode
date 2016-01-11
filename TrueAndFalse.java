public class TrueAndFalse{
	int cnt;
	public int count(String s){
		if(isTrue(s,s.length()))
			return cnt;
		else return 0;
		
	}
	public boolean isTrue(String s, int len){
		boolean flag = false;
		if(s.length()==1)
			return s.charAt(0)=='T'?true:false;
		for(int i = 0; i < s.length();i++){
			char c = s.charAt(i);
			if(c!='^'&& c!='&' && c!='|') continue;
			boolean left = isTrue(s.substring(0,i),len);
			boolean right = isTrue(s.substring(i+1,s.length()),len);
			boolean result = false;
			switch (c){
				case '^': result = left!=right; break;
				case '&': result = (left==true && right == true);break;
				case '|': result = (left ==true || right == true);break;
			}
			if(result){
				if(s.length()==len){
					cnt++;
					System.out.println("("+s.substring(0,i)+")"+c+"("+s.substring(i+1,s.length())+")");
				} 
				flag = true;
			} 
		}
		return flag;
	}
	public static void main(String args[]){
		TrueAndFalse tf = new TrueAndFalse();
		// System.out.println(tf.count("T&F"));
		// System.out.println(tf.count("T|F"));
		// System.out.println(tf.count("T^F"));
		System.out.println(tf.count("T&T|F^F&T"));
		
	}
}