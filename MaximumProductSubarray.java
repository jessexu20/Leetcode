package leetcode;

public class MaximumProductSubarray {
public int maxProduct(int[] A) {
	if (A.length==0) {
		return 0;
	}
	int positiveMax=1;
	int negativeMax=1;
	int max=-10000;
	for (int i = 0; i < A.length; i++) {
		if (A[i]<0) {
			int temp=positiveMax;
			positiveMax=negativeMax;
			negativeMax=temp;
		}
		if (positiveMax*A[i]>A[i]) {
			positiveMax=positiveMax*A[i];
		}
		else {
			positiveMax=A[i];
		}
		if (negativeMax*A[i]<A[i]) {
			negativeMax=negativeMax*A[i];
		}
		else {
			negativeMax=A[i];
		}
		if (positiveMax>max) {
			max=positiveMax;
		}
	}
//	System.out.println(negativeMax);
//	System.out.println(positiveMax);
	return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={4};
		MaximumProductSubarray mps=new MaximumProductSubarray();
		System.out.println(mps.maxProduct(a));
	}

}
