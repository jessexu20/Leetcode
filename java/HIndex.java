public class HIndex {
    public int hIndex(int[] citations) {
		int length=citations.length;
		int [] nums= new int[length+1];
        for(int i=0;i<length;i++){
        	if(citations[i]>=length){
        		nums[length]++;
        	}
			else{
				nums[citations[i]]++;
			}
        }
		int sum=0;
		int i=0;
		for(i=nums.length-1;i>=0;i--){
			sum+=nums[i];
			if(sum>=i)
				break;
		}
		return i;
    }
	public static void main(String args[]){
		HIndex hi=new HIndex();
		int [] c ={0,2,3,1,4};
		System.out.println(hi.hIndex(c));
	}
}