public class DivideIntegers{
    public int divide(int dividend, int divisor) {
        long dividend_l = (long)dividend;
        long divisor_l = (long)divisor;
        boolean negative = ((dividend > 0 && divisor < 0) || 
                   (dividend < 0 && divisor >0)) ? true : false;
        dividend_l = Math.abs(dividend_l);
        divisor_l= Math.abs(divisor_l);
        if (dividend_l < divisor_l) {
            return 0;
        }
		long sub=divisor_l;long ans=0,c=1;
		while(dividend_l>=divisor_l){
			if(dividend_l>=sub){
				dividend_l-=sub;
				ans+=c;
				sub=(sub<<1);
				c=(c<<1);
			}
			else{
				sub=(sub>>1);
				c=(c>>1);
			}
		}
		if(negative)
			ans=-ans;
		else return (int)Math.min(ans, Integer.MAX_VALUE);
		return (int)ans;   
    }
	public static void main(String args[]){
		DivideIntegers di=new DivideIntegers();
		System.out.println(di.divide(-2147483648, -1));
	}
}