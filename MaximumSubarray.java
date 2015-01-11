package leetcode;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if (A.length==0) {
			return 0;
		}
		int b[]=new int[A.length+1];
		b[0]=-10000000;
		for (int i = 0; i < A.length; i++) {
			if (A[i]+b[i] > A[i]) {
				b[i+1]=A[i]+b[i];
			}
			else b[i+1]= A[i];
		}
		int max=-100000;
		for (int i = 0; i < b.length; i++) {
			if (b[i]>max) {
				max=b[i];
			}
//			System.out.println(b[i]);
		}
		return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={-2};
		MaximumSubarray ms=new MaximumSubarray();
		System.out.println(ms.maxSubArray(a));
		
	}

}
