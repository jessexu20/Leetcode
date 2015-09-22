public class FrogJump {
    public int shortestTime(int[] a,int x,int d) {
		int cur=0;
		int lar=0;
		int time=-1;
		for(int i=0;i<a.length;i++){
			if(cur+d>=a[i]){
				if(cur<a[i])
					cur=a[i];
				if(cur+d>lar)
					lar=cur+d;
				if(lar>=x){
					time=i;
					break;
				}
			}
		}
		return lar>=x?time:-1;
    }
	public static void main(String args[]){
		FrogJump fj= new FrogJump();
		int []a ={1,4,6,8,9,2,4};
		System.out.println(fj.shortestTime(a,9,2));
	}
}