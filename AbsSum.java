public class AbsSum {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int min=Integer.MAX_VALUE;
        int count=0,sum=0;
        int length=A.length;
        if(length<=1)
            return 0;
        int p=0;
        for(int i=0;i<length;i++){
        	count+=A[i];
        }
		while(p<length-1){
			count-=A[p];
			sum+=A[p];
			if(Math.abs(count-sum)<min)
				min=Math.abs(count-sum);
			p++;
		}
        return min;
    }
	public static void main(String args[]){
		AbsSum as= new AbsSum();
		int a[]={4,3,2,1,3};
		System.out.println(as.solution(a));
	}
}
