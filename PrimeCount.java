public class PrimeCount {
    public int countPrimes(int n) {
        int []countArray=new int[n+1];
		if(n<2)
			return 0;
		countArray[0]=1;
		countArray[1]=1;
		countArray[2]=0;
		int j =2;int count=0;
		while(j<n){
			for(int i=2;i*j<n;i++){
				countArray[i*j]=1;
			}
			while(j+1<n){
				if(countArray[j+1]==1)
					j++;
				else{
					j=j+1;
					break;
				}
			}
			if(j==n-1)
				break;
		}
		for(int i=0;i<n;i++){
			if(countArray[i]==0)
				count++;
		}
		return count;
	}
	public static void main(String args[]){
		PrimeCount pc=new PrimeCount();
		System.out.println(pc.countPrimes(100000));
	
	}
}