public class Islands {
	int m;int n;
    public int numIslands(char[][] grid) {
		int count=0;
		if(grid.length<=0)
			return 0;
		m=grid.length;
		n=grid[0].length;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]=='1'){
					count++;
					changetoZero(grid,i,j);
				}
			}
		}
		return count;
    }
	public void changetoZero(char[][]grid,int i, int j){
		if(i<0 || j<0 || i>=grid.length|| j>=grid[0].length || grid[i][j]=='0')
			return;
		grid[i][j]='0';
		changetoZero(grid,i+1,j);
		changetoZero(grid,i,j+1);
		changetoZero(grid,i-1,j);
		changetoZero(grid,i,j-1);
	}
	public static void main(String args[]){
		Islands is=new Islands();
		char [][]grid={
			{'1','1','0','0','0'},
			{'1','1','0','0','0'},
			{'0','0','1','0','0'},
			{'0','0','0','1','1'}};
		for(int i =0; i< grid.length;i++){
			for(int j=0;j<grid[0].length;j++)
				System.out.print(grid[i][j]);
			System.out.println();
		}
		System.out.println(is.numIslands(grid));
	}
} 