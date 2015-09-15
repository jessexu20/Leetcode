import java.util.*;
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
		if(matrix.length<1)
        	return 0;
		int rows= matrix.length;
		int cols= matrix[0].length;
		int []left=new int[cols];
		int []right=new int [cols];
		int []height=new int [cols];
		Arrays.fill(right,cols);
		int size=0;
		for(int i=0;i<rows;i++){
			int curleft=0;
			int curright=cols;
			//Count the height
			for(int j=0;j<cols;j++){
				if(matrix[i][j]=='1'){
					height[j]++;
				} 
				else height[j]=0;
			}
			//Count from left
			for(int j=0;j<cols;j++){
				if(matrix[i][j]=='1'){
					left[j]=Math.max(curleft,left[j]);
				} 
				else {
					left[j]=0;
					curleft=j+1;
				}
			}
			//Count from right
			for(int j=cols-1;j>=0;j--){
				if(matrix[i][j]=='1'){
					right[j]=Math.min(curright,right[j]);
				}
				else{ 
					right[j]=cols;
					curright=j;
				}
			}
			//Calculate max size using maxheight*(right[j]-left[j])
			for(int j=0;j<cols;j++){
				size=Math.max(size,(right[j]-left[j])*height[j]);
			}
			// for(int k=0;k<cols;k++){
			// 	System.out.print(left[k]+"\t");
			// }
			// System.out.println();
			// for(int k=0;k<cols;k++){
			// 	System.out.print(right[k]+"\t");
			// }
			// System.out.println();
		}
		return size;
    }
	public static void main(String args[]){
		MaximalRectangle mr = new MaximalRectangle();
		char [][] matrix ={
			{'0','1','0','0','1'},
			{'1','1','1','0','0'}
			// {'0','1','0','1','1'},
// 			{'0','1','1','0','1'}
		};
		// for(int i=0;i<matrix.length;i++){
		// 	for(int j=0;j<matrix[0].length;j++){
		// 		System.out.print(matrix[i][j]+"\t");
		// 	}
		// 	System.out.println();
		// }
		System.out.println(mr.maximalRectangle(matrix));
	}
}