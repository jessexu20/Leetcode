import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
public class ThreeSum{
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
		int j=0,k=0,l=num.length-1;
		List<List<Integer>> res=new ArrayList();
		for(j=0;j<num.length-2;j++){
			if(num[j]>0)
				break;
			k=j+1;
			l=num.length-1;
			while(k<l){
				int sum=num[j]+num[k]+num[l];
				// System.out.println("a="+num[j]+'\t'+"b="+num[k]+'\t'+"c="+num[l]);
				if(sum>0)
					l--;
				else if(sum==0){
					List<Integer> temp=new ArrayList();
					temp.add(num[j]);temp.add(num[k]);temp.add(num[l]);
					res.add(temp);
					while(k<l && num[k]==num[k+1])
						k++;
					while(k<l && num[l]==num[l-1])
						l--;
					k++;
				}
				else
					k++;
			}
		}
		HashSet hs=new HashSet();
		hs.addAll(res);
		res.clear();
		res.addAll(hs);
		return res;
    }
	public static void main(String args[]){
		ThreeSum ts=new ThreeSum();
		int [] num={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		System.out.println(ts.threeSum(num));
	}
}