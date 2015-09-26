public class MyAtoi {
    public int myAtoi(String str) {
        str=str.trim();
		if(str.length()<1)
			return 0;
		if(str.charAt(0)>'9' || str.charAt(0)<'0' && str.charAt(0)!='+' && str.charAt(0)!='-')
			return 0;
		int sign=1;
		if(str.charAt(0)=='+'||str.charAt(0)=='-'){
			sign=(str.charAt(0)=='-'?(-1):1);
			str=str.substring(1,str.length());
		}
		long count =0;
		for(int i = 0;i<str.length();i++){
			if(str.charAt(i)>'9' || str.charAt(i)<'0')
				break;
			count= 10* count + (str.charAt(i)-'0');
			if(count>Integer.MAX_VALUE){
				return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
			}
		}
		return (int)(sign*count);
    }
	public static void main(String args[]){
		MyAtoi my= new MyAtoi();
		System.out.println(my.myAtoi("+a"));
	}
}