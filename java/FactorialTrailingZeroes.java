public class FactorialTrailingZeroes{
	
    public int trailingZeroes(int n) {
        int count = 0;
        for(long i = 5; i <= n; i*=5)
            count += (int)(n/i);
        return count;
    }
	public static void main(String args[]){
		 FactorialTrailingZeroes ftz= new FactorialTrailingZeroes();
		 System.out.println(ftz.trailingZeroes(75));
		
	}
} 