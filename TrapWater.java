public class TrapWater{
    public int trap(int[] A) {
		int temp=0;
		if(A.length<3)
			return 0;
		int start=0,end=0,sum=0;
		while(start<A.length && A[start]==0 )
			start++;
		if(start==A.length)
			return 0;
		// System.out.println("Start="+start+"end="+end+"sum="+sum);
		while(start<A.length-1){
			end=start+1;
			while(end<A.length&&A[end]<A[start]){
				temp+=(A[start]-A[end]);
				end++;
			}
			// System.out.println("Start="+start+"end="+end+"sum="+sum+"temp="+temp);
			if(end!=A.length){
				sum+=temp;
				temp=0;
				start=end;
			}
			else{
				A[start]--;
				temp=0;
			}
			// System.out.println("Start="+start+"end="+end+"sum="+sum);
		}
		return sum;
    }
	
	public static void main(String args[]){
		TrapWater tw= new TrapWater();
		// int [] num={0,1,0,2,1,0,1,3,2,1,2,1};
		int [] num={4,2,3};
		System.out.println(tw.trap(num));
		
	}
}