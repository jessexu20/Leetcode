public class MiniSquare{
	public int minNumber(int n){
		int [] f = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= n ; i++){
			int j = 1;
			int min = Integer.MAX_VALUE;
			while(j*j <= i){
				int cur = 1 + f[i-j*j];
				min = Math.min(min, cur);
				j++;
			}
			f[i] = min;
		}
		return f[n];
	}
	public static void main(String args[]){
		MiniSquare ms= new MiniSquare();
		System.out.println(ms.minNumber(27));
	}
}
