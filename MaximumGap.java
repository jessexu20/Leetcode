import java.util.*;
public class MaximumGap{
    public int maximumGap(int[] num) {
        if(num.length<2)
			return 0;
		radixSort(num);
		int max=Integer.MIN_VALUE;
		for(int i=0;i<num.length-1;i++){
			if(num[i+1]-num[i]>max)
				max=num[i+1]-num[i];
		}
		return max;
    }
	public void radixSort(int []num){
		List<Integer> sorted=new ArrayList();
		for(int i:num){
			sorted.add(i);
		}
		List<Integer> buck0=new ArrayList();
		List<Integer> buck1=new ArrayList();
		int mask=1;
		while(mask>0){
			for(int i=0;i<num.length;i++){
				if((mask & sorted.get(i))==0)
					buck0.add(sorted.get(i));
				else
					buck1.add(sorted.get(i));
			}
			sorted.clear();
			sorted.addAll(buck0);
			sorted.addAll(buck1);
			buck0.clear();
			buck1.clear();
			mask<<=1;
		}
		for(int i=0;i<num.length;i++){
			num[i]=sorted.get(i);
		}
	}
	public static void main(String args[]){
		MaximumGap mg=new MaximumGap();
		int [] num= {2,1,4,1,2,4,2,3,12,3,4,1,10};
		mg.radixSort(num);
		System.out.println(mg.maximumGap(num));
	}
}