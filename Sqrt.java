public class Sqrt{
    public int sqrt(int x) {
    	if (x<=0) {
			return 0;
		}
		int low=1;
		int high=x;
		int mid=(low+high)/2;
		while(low<high && low!=mid && mid!=high){
			if(mid<x/mid){
				low=mid;
				mid=(low+high)/2;
			}
			else if(mid>x/mid){
				high=mid;
				mid=(low+high)/2;
			}
			else if (mid*mid<x &&(mid+1)*(mid+1)>x) {
				return mid;
			}
			else
				return mid;
		}
		return mid;
    }
	public static void main(String args[]){
		Sqrt s=new Sqrt();
		int x=196;
		System.out.println(s.sqrt(x));
	}
}