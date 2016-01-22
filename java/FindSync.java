import java.util.*;
public class FindSync{
	public List<Integer> findSync(int [] nums1, int [] nums2){
		Set<Integer> set = new HashSet();
		List<Integer> list = new ArrayList();
		for(int i = 1; i < nums1.length; i++){
			nums1[i]+=nums1[i-1];
			set.add(nums1[i-1]);
		}
		set.add(nums1[nums1.length-1]);
		for(int i = 1; i < nums2.length;i++){
			nums2[i]+=nums2[i-1];
			if(!set.add(nums2[i-1])) list.add(nums2[i-1]);
		}
		if(!set.add(nums2[nums2.length-1])) list.add(nums2[nums2.length-1]);
		return list;
	}
	public List<Integer> findSync2(int [] nums1, int [] nums2){
		//Merge Sort
		List<Integer> list = new ArrayList();
		for(int i = 1; i < nums1.length; i++){
			nums1[i]+=nums1[i-1];
		}
		for(int i = 1; i < nums2.length;i++){
			nums2[i]+=nums2[i-1];
		}
		int i = 0,j = 0;
		while(i<nums1.length && j <nums2.length){
			if(nums1[i]<nums2[j]) i++;
			if(nums1[i]>nums2[j]) j++;
			else{
				list.add(nums1[i]);
				i++;
				j++;
			} 
		}
		return list;
	}
	public static void main(String args[]){
		FindSync find = new FindSync();
		int [] nums1= {1,5,8,9};
		int [] nums2= {1,4,9,9};
		System.out.println(find.findSync2(nums1,nums2));
	}
}
	