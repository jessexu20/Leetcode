public class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length==0)
			return false;
		int m=matrix.length;
		int n=matrix[0].length;
		for(int i=0;i<m;i++){
			if(matrix[i][0]>target)
				return false;
			if (binarySearch(matrix[i],0,n-1,target))
				return true;
		}
        return false;
    }
	public boolean binarySearch(int [] array,int start,int end,int num){
		if((start==end && num!=array[start]) ||num<array[start]||num>array[end] ){
			return false;
		}
		if(num==array[end] || num==array[start])
			return true;
		int mid=(start+end)/2;
		if(num>array[mid])
			return binarySearch(array,mid+1,end,num);
		else return binarySearch(array,start,mid,num);
	}
	public static void main(String args[]){
		MatrixSearch ms=new MatrixSearch();
		int [][] nums={ {1,4,7,11,15},
						{2,5,8,12,19},
						{3,6,9,16,22},
						{10,13,14,17,24},
						{18,21,23,26,30}
						};
		// for(int i=0;i<nums.length;i++){
		// 	for(int j=0;j<nums[0].length;j++)
		// 		System.out.print(nums[i][j]+"\t");
		// 	System.out.println();
		// }
		System.out.println(ms.searchMatrix(nums,10));
		System.out.println(ms.searchMatrix(nums,19));
		
		
	}

}