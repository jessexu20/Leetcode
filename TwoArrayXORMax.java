import java.util.*;
public class TwoArrayXORMax{
	public int findMax(int [] arr1, int [] arr2){
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		for(int i: arr1)
			l1.add(base(i,2,32));
		for(int i: arr2)
			l2.add(base(i,2,32));
		String result = findMax(l1,l2,0);
		System.out.println(result);
		return Integer.valueOf(result,2);
	}
	public String findMax(List<String> list1, List<String> list2,int index){
		if(index >= 32)
			return "";
		List<String> ones1 = new ArrayList<String>();
		List<String> zeros1 = new ArrayList<String>();
		List<String> ones2 = new ArrayList<String>();
		List<String> zeros2 = new ArrayList<String>();
		for(int i = 0; i < list1.size(); i++){
			if(list1.get(i).charAt(index)=='0')
				zeros1.add(list1.get(i));
			else ones1.add(list1.get(i));
		}
		for(int i = 0; i < list2.size(); i++){
			if(list2.get(i).charAt(index)=='0')
				zeros2.add(list2.get(i));
			else ones2.add(list2.get(i));
		}
		boolean check1 = ones1.size()!=0 && zeros2.size()!=0;
		boolean check2 = ones2.size()!=0 && zeros1.size()!=0;
		if(check1 || check2){
			if(!check1)
				return "1" + findMax(ones2,zeros1,index+1);
			else if(!check2)
				return "1" + findMax(ones1,zeros2,index+1);
			else{
				String t1 = findMax(ones2,zeros1,index+1);
				String t2 = findMax(ones1,zeros2,index+1);
				if(t1=="" && t2=="")
					return "1";
				else return "1" + (Integer.valueOf(t1) < Integer.valueOf(t2)? t2:t1);
			}
		}
		else return "0"+ findMax(list1,list2,index+1);
	}
	public String base(int num, int x, int len){
		String temp = Integer.toString(num,x);
		while(temp.length()<len)
			temp = "0"+temp;
		return temp;
	}
	public static void main(String args[]){
		TwoArrayXORMax arr = new TwoArrayXORMax();
		int [] nums1= {1,2,3};
		int [] nums2 = {4,5,6};
		System.out.println(arr.findMax(nums1,nums2));
	}
}
