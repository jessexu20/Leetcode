//  43261596 (represented in binary as 00000010100101000001111010011100),
// 964176192 (represented in binary as 00111001011110000010100101000000
// 10000000000000000000000000000000
public class ReverseBits{
	public int reverseBits(int n) {
		long count=0;
		int num=0;
		for(int i=n;n>0;n/=2){
			count+=n%2;
			count*=2;
			num+=1;
		}
		for(int i=num+1;i<32;i++){
			count*=2;
		}
		System.out.println(count);
		
		return (int)count;
    }
	
	
	public static void main(String args[]){
		ReverseBits rb= new ReverseBits();
		System.out.println(rb.reverseBits(43261596));
	}
	
} 