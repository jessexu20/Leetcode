public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int size1=0,size2=0;
		if (A<C && B<D){
        	size1=(C-A)*(D-B);
        }
		if(E<G && F<H){
			size2=(E-G)*(F-H);
		}
		if(size1==0 || size2==0){
			return size1==0?size2:size1;
		}
		int sx1=0,sx2=0,sy1=0,sy2=0;
		if(C>E){
			sx1=Math.max(A,E);
			sx2=Math.min(C,G);
		}
		if(B<H){
			sy1=Math.max(B,F);
			sy2=Math.min(D,H);
		}
		int size3=(sx2-sx1)*(sy2-sy1);
		System.out.println(sx1);
		System.out.println(sx2);
		System.out.println(sy1);
		System.out.println(sy2);
		return size1+size2-size3;
		
    }
	public static void main(String args[]){
		RectangleArea ra= new RectangleArea();
		System.out.println(ra.computeArea(-3,0,3,4,0,-1,9,2));
		
	}
}