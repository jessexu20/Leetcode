public class TurnBase{
	public String encode(int num,int base){
		StringBuffer sb= new StringBuffer();
		while(num>0){
			int remainder=num % base;
			sb.append(Integer.toString(remainder));
			num= num/base;
		}	
		return sb.reverse().toString();
	}
	public String encode2(int num, int base){
		//from base 10 to base `base`
		return Integer.toString(num,base);
	}
	public Integer decode(String str,int base){
		//from base `base` to base 10
		return Integer.valueOf(str,base);
	}
	public static void main(String args[]){
		int num=101;
		TurnBase tb= new TurnBase();
		System.out.println(tb.encode(num,8));
		System.out.println(tb.encode2(num,8));
		System.out.println(tb.decode("145",8));
	}
}