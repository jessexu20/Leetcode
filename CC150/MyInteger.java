public class MyInteger{//7.4
	public int negate(int a){
		if(a==0)
			return 0;
		int d= a>0? -1:1;
		if(d==1){
			while(a<-1){
				d++;
				a++;
			}
		}
		else{
			while(a>1){
				d+=-1;
				a+=-1;
			}
		}
		return d;
	}
	public int  substract(int a, int b){
		return a+negate(b);
	}
	public int multiply(int a ,int b){
		if(a<b)
			return multiply(b,a);
		int count =0;
		if(b>0){
			for(int i=0;i<b;i++){
				count+=a;
			}
			return count;
		}
		else if(b==0)
			return 0;
		else{
			for(int i=b;i<0;i++)
				count+=negate(a);
			return count;
		}
		
	}
	public int divide(int a ,int b){
		int count =0;
		if(a==0)
			return 0;
		if(b==0)
			return -1;
		if(a<0 && b<0){
			while((a=substract(a,b))<0){
				count++;
			}
			return count;
		}
		else if(a<0 && b>0){
			while((a=a+b)<0){
				count++;
			}
			return negate(count);
		}
		else if(a>0 && b<0){
			while((a=(a+b))>0){
				count++;
			}
			return negate(count);
		}
		else{
			while((a=substract(a,b))>0){
				count++;
			}
			return count;
		}
	}
	public static void main(String args[]){
		MyInteger mi=new MyInteger();
		System.out.println(mi.substract(5,3));
		System.out.println(mi.multiply(5,-3));
		System.out.println(mi.divide(5,-3));
	}
	
}