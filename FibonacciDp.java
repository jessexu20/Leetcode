public class FibonacciDp{
	public int getN(int n){
		int res[]=new int[n+1];
		res[0]=1;res[1]=1;
		for(int i=2;i<n;i++){
			res[i]=res[i-1]+res[i-2];
		}
		return res[n-1];
	}
	public static void main(String args[]){
		FibonacciDp fd=new FibonacciDp();
		System.out.println(fd.getN(10));
	}
	
	
}