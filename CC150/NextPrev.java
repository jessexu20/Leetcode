public class NextPrev{//5.3
	public int getNext(int x){
		int ones=0;
		int zeros=0;
		int c=1;
		while((c&x)==0){
			c<<=1;
			zeros+=1;
		}
		while((c&x)!=0){
			c<<=1;
			ones+=1;
		}
		
		int mask=~0;
		mask<<=(ones+zeros);
		int temp=mask&x+c;
		zeros++;
		ones--;
		if(ones>0){
			c=1;
			for(int i=0;i<ones-1;i++)
				c=(c<<1)+1;
			x=c+temp;
		}
		else x=temp;
		return x;
	}
	public int getPrev(int x){
		int ones=0;
		int zeros=0;
		int c=1;
		while((c&x)!=0){
			ones++;
			c<<=1;
		}
			
		while((c&x)==0){
			zeros++;
			c<<=1;
		}
			
		int mask=~0;
		mask<<=(ones+zeros+1);
		x=x&mask;
		ones++;
		zeros--;
		c=1;
		for(int i=0;i<ones-1;i++){
			c=(c<<1)+1;
		}
		c<<=zeros;
		return x+c;
	}
	public void test(){//5.4
		for(int n=1;n<2000;n++){
			if ((n & (n-1)) == 0)//test if n is power of 2 
				System.out.println(n);
		}
	}
	public static void main(String args[]){
		NextPrev np=new NextPrev();
		System.out.println(np.getNext(85));
		System.out.println(np.getPrev(85));
		np.test();
	}
}