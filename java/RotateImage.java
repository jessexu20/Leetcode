public class RotateImage{
    public void rotate(int[][] matrix) {
		int rowNum=matrix.length;
		int colNum=0;
		if(rowNum==0)
			return;
		else
			colNum=matrix[0].length;
		int [][]temp=new int[rowNum][colNum];
		for(int i=0;i<rowNum;i++){
			for(int j=0;j<colNum;j++){
				temp[i][j]=matrix[i][j];
			}
		}
		for(int i=0;i<rowNum;i++){
			for(int j=0;j<colNum;j++){
				matrix[i][j]=temp[colNum-j-1][i];
			}
		}
        return;
    }
	public static void main(String args[]){
		RotateImage ri=new RotateImage();
		int [][]inputMatrix={{1,2,3},{4,5,6},{7,8,9}};
		ri.rotate(inputMatrix);
		for(int i=0; i<inputMatrix.length;i++){
			for(int j=0;j<inputMatrix[0].length;j++){
				System.out.print(inputMatrix[i][j]);
				System.out.print('\t');
			}
			System.out.println();
		}
	}
}