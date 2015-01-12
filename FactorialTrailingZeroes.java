public class FactorialTrailingZeroes{
	
    public int trailingZeroes(int n) {
		double num5=Math.floor(Math.log(n)/Math.log(5));
		int n5=(int) num5;
		int sum=0;
		for(int i=0;i<n5;i++){
			double divide=Math.pow(5,i+1);
			sum+=n/divide;
		}
        return sum;
    }
	public static void main(String args[]){
		 FactorialTrailingZeroes ftz= new FactorialTrailingZeroes();
		 System.out.println(ftz.trailingZeroes(75));
		
	}
} 