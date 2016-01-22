public class Container{
	public int maxArea(int[] height) {
        int low=0;int high=height.length-1;
		int size=0;
		while(low<high){
			size=Math.max(size,(high-low)*Math.min(height[high],height[low]));
			if(height[low]<height[high]) low++;
			else high--;
		}
		return size;
	}
	public static void main(String args[]){
		Container container=new Container();
		int [] height={1,3,4,2,5,6,1};
		System.out.println(container.maxArea(height));
	}
}
