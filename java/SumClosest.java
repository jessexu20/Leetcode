import java.util.Arrays;
public class SumClosest {
    public int threeSumClosest(int[] num, int target) {
		int sum=0;
		int absMin=Integer.MAX_VALUE;
		int res=0;
		if(num.length<=3){
			for(int i:num)
				sum+=i;
			return sum;
		}
		sum=num[0]+num[1]+num[2];
		Arrays.sort(num);
		for(int i=0;i<num.length-2;i++){
			int j=i+1;
			int k=num.length-1;
			while(j<k){
				sum=num[i]+num[j]+num[k];
				if(sum==target)
					return target;
				else{
					if(target>sum)
						j++;
					else k--;
					if(Math.abs(target-sum)<absMin){
						res=sum;
						absMin=Math.abs(target-sum);
					}	
				}
			}
		}
		return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumClosest sc=new SumClosest();
		int []num={0,2,1,-3};
		int target=1;
		System.out.println(sc.threeSumClosest(num, target));
	}

}
