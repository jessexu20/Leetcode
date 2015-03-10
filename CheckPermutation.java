public class CheckPermutation {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int count=0;int sum=0;
		int max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            count+=(i+1);
            sum+=A[i];
			if(max<A[i])
				max=A[i];
			if(A[i]<=0)
				return 0;
        }
		if(sum!=count){
			System.out.println("Ff");
			return 0;
		}
			
		else{
			if(max!=A.length){
				System.out.println("Fadf");
				return 0;
			}
				
			else return 1;
		}
    }
	public static void main(String args[]){
		CheckPermutation as= new CheckPermutation();
		int a[]={4,1,2,3};
		System.out.println(as.solution(a));
	}
}