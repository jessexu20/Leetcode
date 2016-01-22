public class PowerTwo {
    public boolean isPowerOfTwo(int n) {
		if 
        while (n >1){
        	if ((n & 1) ==1)
				return false;
			else n>>=1;
        }
		return true;
    }
	public static void main(String args[]){
		PowerTwo pt =new PowerTwo();
		for(int i =1;i<33;i++){
			System.out.println(pt.isPowerOfTwo(i));
		}
		
	}
}