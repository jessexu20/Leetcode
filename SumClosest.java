package leetcode;

public class SumClosest {
    public int threeSumClosest(int[] num, int target) {
    	int sum[]=new int[num.length*num.length];
    	int count=0;
    	for (int i = 0; i < num.length; i++) {
			for (int j = i+1; j < num.length; j++) {
				for (int k = j+1; k < num.length; k++) {
					sum[count]=num[i]+num[j]+num[k];
					if (sum[count]==target) {
//						System.out.println(sum[count]);
						return target;
					}
					count++;
				}
			}
		}
    	int min=10000;
    	int index=0;
    	for (int i = 0; i < sum.length; i++) {
    		System.out.println(sum[i]);
			if (sum[i]>target) {
				if (min>sum[i]-target) {
					min=sum[i]-target;
					index=i;
				}
			}
			else {
				if (min>target-sum[i]) {
					min=sum[i]-target;
					index=i;
				}
			}
		}
		return sum[index];
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumClosest sClosest=new SumClosest();
		int []num={-1,2,1,-4};
		int target=1;
		System.out.println(sClosest.threeSumClosest(num, target));
	}

}
