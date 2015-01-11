public class FindPeak {
    public int findPeakElement(int[] num) {
		int j=0;
		if(num.length==0 ||num.length==1 ) return 0;
        for(int i=1;i<num.length;i++){
        	if(num[i]>num[i-1])
				j=i;
			if(i+1==num.length)
				return j;
			else{
				if(num[i+1]<num[i])
					return j;
			}
        }
		return j;
    }
	public static void main(String args[]){
		FindPeak fp=new FindPeak();
		int [] num={1,2,3,2};
		System.out.println(fp.findPeakElement(num));
	}
}