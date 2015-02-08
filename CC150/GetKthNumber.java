import java.util.*;
public class GetKthNumber{
	Queue<Integer> queue3=new LinkedList();
	Queue<Integer> queue5=new LinkedList();
	Queue<Integer> queue7=new LinkedList();
	
	public int getKthNumber(int k){//Chapter 7
		if(k<0)
			return 0;
		queue3.add(3);
		queue5.add(5);
		queue7.add(7);
		int res=0;
		for(int i=0;i<k;i++){
			int val=Math.min(queue3.peek(),Math.min(queue5.peek(),queue7.peek()));
			if(val==queue3.peek()){
				res=queue3.poll();
				queue3.add(3*res);
				queue5.add(5*res);
				queue7.add(7*res);
			}
			else if(val==queue5.peek()){
				res=queue5.poll();
				queue5.add(5*res);
				queue7.add(7*res);
			}
			else{
				res=queue7.poll();
				queue7.add(7*res);
			}
		}
		return res;
	}
	public static void main(String args[]){
			GetKthNumber gkn=new GetKthNumber();
			System.out.println(gkn.getKthNumber(5));
	}
}