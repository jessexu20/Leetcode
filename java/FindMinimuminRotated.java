public class FindMinimuminRotated{
    public int findMin(int[] num) {
        int length=num.length;
		if(length==0)
			return 0;
		if(length==1)
			return num[0];
		if(num[0]<num[length-1]){
			return num[0];
		}
		else{// if(num[0]>=num[length-1])
			int i=length-1;
			while(i>0 && num[i]>=num[i-1])
				i--;
			if(i>0)
				return num[i];
			else return num[0];
		}
   	}
	public static void main(String args[]){
		FindMinimuminRotated rmr=new FindMinimuminRotated();
		int []num={0 ,1 ,2,4,4,4,4};
		System.out.println(rmr.findMin(num));
	}
}