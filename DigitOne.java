public class DigitOne {
    public int countDigitOne(int n) {
		int count =0;
		for(long i=1;i<=n;i*=10){
			long r=n/i;long m=n%i;
			count+=((r+8)/10*i+(r%10==1?m+1:0));
		}
		return count;
    }
	public static void main (String args[]){
		DigitOne d=new DigitOne();
		System.out.println(d.countDigitOne(11));
	}
}