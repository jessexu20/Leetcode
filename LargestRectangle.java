import java.util.*;
public class LargestRectangle{
    public int largestRectangleArea(int[] height) {
        Stack <Integer> stack= new Stack();
		int size=0,i=0;
		for(i=0; i<height.length;i++){	
			while(!stack.isEmpty() && height[stack.peek()]>height[i]){
				int p = stack.pop();
				if(!stack.isEmpty()) size=Math.max(size,(i-stack.peek()-1)*height[p]);
				else size=Math.max(size,i*height[p]);
			}
			stack.push(i);
		}
		// System.out.println(stack);
		while(i==height.length && !stack.isEmpty()){
			int p=stack.pop();
			if(!stack.isEmpty()) size=Math.max(size,(i-stack.peek()-1)*height[p]);
			else size=Math.max(size,(height.length)*height[p]);
		}
		return size;
    }
	public static void main(String args[]){
		LargestRectangle lr= new LargestRectangle();
		int [] num= {4,2,0,3,2,5};
		System.out.println(lr.largestRectangleArea(num));
	}
}