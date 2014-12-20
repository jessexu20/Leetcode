public class SpiralMatrix{
	public int [] up(int [][] num, int startNum,int length,int i,int j){
		for(int y=0;y<length;y++){
			startNum+=1;
			num[i-y][j]=startNum;
		}
		int pos[]=new int[2];
		pos[0]=i-length+1;
		pos[1]=j+1;
		return pos;
	}
	public int [] down(int [][] num, int startNum,int length,int i,int j){
		for(int y=0;y<length;y++){
			startNum+=1;
			num[i+y][j]=startNum;
		}
		
		int pos[]=new int[2];
		pos[0]=i+length-1;
		pos[1]=j-1;
		return pos;
	}
	public int [] left(int [][] num, int startNum,int length,int i,int j){
		for(int x=0;x<length;x++){
			startNum+=1;	
			num[i][j+x]=startNum;
		}
		int pos[]=new int[2];
		pos[0]=i+1;
		pos[1]=j+length-1;
		return pos;
	}
	public int [] right(int [][] num, int startNum,int length,int i,int j){
		for(int x=0;x<length;x++){
			startNum+=1;
			num[i][j-x]=startNum;
		}
		int pos[]=new int[2];
		pos[0]=i-1;
		pos[1]=j-length+1;
		return pos;
	}
	public int [][] generateMatrix(int n){
		int [][]ans=new int[n][n];
		int length=n;
		int start=0;
		int []position={0,0};
		while(length>0){
			position=left(ans,start,length,position[0],position[1]);
			position=down(ans,start+=length,length-=1,position[0],position[1]);
			position=right(ans,start+=length,length,position[0],position[1]);
			position=up(ans,start+=length,length-=1,position[0],position[1]);
			start+=length;
		}
		return ans;
	}
	public static void main(String args[]){
		SpiralMatrix sm=new SpiralMatrix();
		int m =4;
		int [][] res=new int [m][m];
		res=sm.generateMatrix(m);
		for(int i=0;i<m;i++){
			for(int j=0;j<m;j++){
				System.out.print(res[i][j]);
				System.out.print('\t');	
			}
			System.out.println();
		}
	
	}
}