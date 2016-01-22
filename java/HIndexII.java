public class HIndexII {
    public int hIndex(int[] citations) {
		int length=citations.length;
		int sum=0;
		int i=0;
		for(i=citations.length-1;i>=0;i--){
			sum+=1;
			if(sum>=citations[i])
				break;
		}
		if (i==-1){
			return sum;
		}
		return Math.max(citations[i],sum-1);
    }
	public static void main(String args[]){
		HIndexII hi=new HIndexII();
		int [] c ={0,1,1,1,5,5,10,16};
		System.out.println(hi.hIndex(c));
	}
}