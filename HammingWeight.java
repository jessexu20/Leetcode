public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
           int count = 0;
           for(int i=0; i < 32; i++) {
               if((n & (1 << i)) != 0)
				    count++;
			   System.out.println(i);
			   
           }
           return count;
       }
	public static void main(String args[]){
		HammingWeight hw =new HammingWeight();
		System.out.println(hw.hammingWeight(11));
	
	}
}