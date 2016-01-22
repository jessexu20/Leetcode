import java.util.*;
public class CountComponents{
	public int countComponents(int n, int [][] edges){
		
		int [] pos = new int [n];
		for(int i = 0; i < n; i++){
			pos[i] = i;
		}
		for(int i = 0; i < edges.length; i++){
			int x = edges[i][0];
			int y = edges[i][1];
			union(pos,x,y);
		}
		Set<Integer> cnt = new HashSet<>();
		for(int i: pos)
			System.out.print(i+"\t");
		for(int i : pos)
			cnt.add(i);
		return cnt.size();
	}
	public void union(int [] pos, int x, int y){
		int a = find(pos,x);
		int b = find(pos,y);
		if(x<y){
			pos[y] = a;
		}
		else pos[x] = b;
	}
	private int find(int [] pos, int x){
		if(pos[x]==x)
			return x;
		else return find(pos,pos[x]);
	}
	public static void main(String args[]){
		CountComponents cc = new CountComponents();
		int [][] edges = {{0,1},{1,2},{3,4}};
		
		System.out.println(cc.countComponents(5,edges));
		
	}
}