public class BitChange{
	public int bitchange(int x,int y){//5.5
		int count =0 ;
		int temp=x^y;
		// int c=1;
		// while(c<temp){
		// 	if((c&temp)!=0)
		// 		count++;
		// 	c<<=1;
		// }
		while(temp!=0){
			count++;
			temp=temp&(temp-1);
		}
		return count;
	}
	public static void main(String args[]){
		BitChange bc= new BitChange();
		System.out.println(bc.bitchange(31,14));
		
	}
}