import java.util.*;
public class JumpArray{
	public boolean canJump(int [] arr){
		Set<Integer> visited = new HashSet<>();
		if(arr.length < 1) return true;
		int number = 0;
		while(visited.add(number)){
			number = (number + arr[number]) % arr.length;
		}
		return visited.size() == arr.length;
	}
	public static void main(String args[]){
		JumpArray ja = new JumpArray();
		int [] arr1= {1,1,1,1,1,1};
		int [] arr2= {0,1,1,1,1,1};
		int [] arr3= {7,5,2,3};
		int [] arr4= {2,2,3,1};
		System.out.println(ja.canJump(arr1));
		System.out.println(ja.canJump(arr2));
		System.out.println(ja.canJump(arr3));
		System.out.println(ja.canJump(arr4));
		// System.out.println(ja.canJump(arr5));
		
	
	}
}