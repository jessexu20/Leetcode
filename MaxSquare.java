public class MaxSquare {
    public int findmin(int a ,int b, int c){
		return Math.min(a,b)<Math.min(b,c)?Math.min(a,b):Math.min(b,c);
	}
    public int maximalSquare(char[][] matrix) {
        int max=0;
		if(matrix.length<1)
			return 0;
		int [][]p=new int [matrix.length][matrix[0].length];
		for(int i=0;i<p[0].length;i++){
			p[0][i]=matrix[0][i]-'0';
			if(p[0][i]>max)
					max=p[0][i];
		}
		for(int i=0;i<p.length;i++){
			p[i][0]=matrix[i][0]-'0';
			if(p[i][0]>max)
					max=p[i][0];
		}
		for(int i=1;i<p.length;i++){
			for(int j=1;j<p[0].length;j++){
				if(matrix[i][j]=='0')
					p[i][j]=0;
				else{
					p[i][j]=findmin(p[i-1][j],p[i-1][j-1],p[i][j-1])+1;
					if(p[i][j]>max)
						max=p[i][j];
				}
			}
		}
        return max*max;
    }
	public static void main(String args[]){
		MaxSquare ms= new MaxSquare();
		char [][] matrix={{0}};
		// char [][] matrix={{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
		// System.out.println(ms.findmin(1,1,3));


		System.out.println(ms.maximalSquare(matrix));
	}
}