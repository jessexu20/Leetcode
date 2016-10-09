public class PerfectSquares {
    public int numSquares(int n) {
        int [] result= new int [n+1];
        result[0]=0;
        for(int i=1;i<n+1;i++){
            int sqrt=(int)Math.sqrt(i);
            int square=(sqrt*sqrt);
			int min=Integer.MAX_VALUE;
			for(int j=1;j<=sqrt;j++){
				if(result[i-j*j]+1<min)
					min=result[i-j*j]+1;
			}
            result[i]=Math.min(result[i-1]+1,min);
        }
		// for(int i=0;i<n+1;i++){
		// 	System.out.print(i+"\t");
		// }
		// System.out.println();
		// for(int i:result){
		// 	System.out.print(i+"\t");
		// }
        return result[n];
    }
	public static void main(String args[]){
		PerfectSquares s = new PerfectSquares();
		System.out.println(s.numSquares(36));
	}
}