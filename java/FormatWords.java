import java.util.*;
public class FormatWords{
	public int canPlace(String str,int m, int n){
		String [] arr = str.split(" ");
		int [] len = new int [arr.length];
		for(int i = 0; i < arr.length; i++){
			len[i] = arr[i].length();
		}
		Queue<Integer> que = new LinkedList<>();
		Queue<String> strque = new LinkedList<>();
		for(int i: len)
			que.offer(i);
		for(String s:arr)
			strque.offer(s);
		que.offer(-1);//mark end
		int counter = 0;
		StringBuilder sb = new StringBuilder();
		int i = 0; int j = 0;//i -> row, j ->col
		while(i<n){
			while(j<=m){
				int num = que.peek();
				if(num==-1){
					counter++;
					que.offer(que.poll());
					continue;
				}
				if(j+num<=m){
					j+=num;
					j++;
					sb.append(strque.peek()+" ");
					strque.offer(strque.poll());
					que.offer(que.poll());
				}
				else break;
			}
			sb.append("\n");
			i++;
			j=0;
		}
		if(que.peek()==-1) counter++;
		System.out.println(sb.toString());
		return counter;
	}
	public static void main(String args[]){
		FormatWords fw = new FormatWords();
		System.out.println(fw.canPlace("abc cd e xyz",12,5));
	}
}