public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int []result=new int[n];
		result[0]=1;
		if(n==1)
			return 1;
		int p2=0,p3=0,p5=0;
		for(int i=1;i<n;i++){
			result[i]=findMin(result[p2]*2,result[p3]*3,result[p5]*5);
			if(result[i]==result[p2]*2)
				p2++;
			if(result[i]==result[p3]*3)
				p3++;
			if(result[i]==result[p5]*5)
				p5++;
		}
		return result[n-1];
		
    }
	public int findMin(int a,int b,int c){
		return (a < b ? a : b) <  (b < c ? b : c) ? (a < b ? a : b) : (b < c ? b : c);
	}
	public static void main(String args[]){
		UglyNumberII uni=new UglyNumberII();
		System.out.println(uni.nthUglyNumber(10));
	}
}