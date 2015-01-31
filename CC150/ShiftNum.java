public class ShiftNum{//5.1
	public int shift(int m,int n,int i, int j){
		int allOnes=~0;
		allOnes<<=(j+1);
		int right=(1<<i)-1;
		int mask=allOnes|right;
		n&=mask;
		int num=1;
		for(int k=0;k<j-i;k++)
			num<<=1;
		if(m>=num && m<num<<1){
			n+=m<<i;
			System.out.println(n);
		}
		else if(m>=num<<1){
			return Integer.MIN_VALUE;
		}
		else{
			int count=0;
			while(m<num){
				num>>=1;
				count++;
			}
			n+=m<<(i+count);
			System.out.println(n);
		}
			
			
		return 0;
	}
	public static void main(String args[]){
		ShiftNum sn=new ShiftNum();
		sn.shift(16,1024,2,6);
	}
}