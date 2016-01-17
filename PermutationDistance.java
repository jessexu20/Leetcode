import java.util.*;
public class PermutationDistance{
	public List<String> permutation(int []nums, int distance){
		List<String> result = new ArrayList();
		int [] values = new int[128];// 7 digit ASCII
		for(int i = 0; i < nums.length; i++){
			values['0'+nums[i]]++;
		}
		int [] dist = new int[128];
		Arrays.fill(dist,-1);
		helper(result,nums.length,values,dist,distance,"");
		return result;
	}
	private void helper(List<String> result, int len, int [] values, int [] dist,int distance,String temp){
		if(len == 0){
			result.add(temp);
			return;
		}
		for(int i = 0; i < values.length; i++){
			//more than distance
			// if(values[i]>0 && (dist[i]==-1 || temp.length()>dist[i]+distance)){
			// 	values[i]--;
			// 	int t = dist[i];
			// 	dist[i] = temp.length();
			// 	helper(result,len-1,values,dist,distance,temp+(char)i);
			// 	values[i]++;
			// 	dist[i] = t;
			// }
			// less than distance
			if(values[i]>0 && (dist[i]==-1 || temp.length()<=dist[i]+distance)){
				values[i]--;
				int t = dist[i];
				dist[i] = temp.length();
				helper(result,len-1,values,dist,distance,temp+(char)i);
				values[i]++;
				dist[i] = t;
			}
		}
	}
	public static void main(String args[]){
		PermutationDistance pd = new PermutationDistance();
		int [] nums = {1,1,2,3,4,5,6};
		System.out.println(pd.permutation(nums,3));
	}
}