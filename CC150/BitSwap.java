public class BitSwap{//5.6
	public int bitSwap(int x){
		int evenMask=0xAAAAAAAA;
		int oddMask=0x55555555;
		return ((x&evenMask)>>1)+((x&oddMask)<<1);
		
	}
	public static void main(String args[]){
		BitSwap bs=new BitSwap();
		System.out.println(bs.bitSwap(10));
	}
	
}