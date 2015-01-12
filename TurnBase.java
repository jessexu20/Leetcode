public class TurnBase{
	public void encode(int num,int base){
		StringBuffer sb= new StringBuffer();
		while(num>0){
			int remainder=num % base;
			sb.append(Integer.toString(remainder));
			num= num/base;
		}	
		System.out.println(sb.reverse());
	}
	
	public static void main(String args[]){
		int num=101;
		TurnBase tb= new TurnBase();
		tb.encode(num,8);
	}
}