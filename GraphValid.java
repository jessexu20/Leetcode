/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/
public class GraphValid {
	public class Solution {
	    public boolean validTree(int n, int[][] edges) {
	        int [] unionset= new int [n];
	        for(int i =0;i<unionset.length;i++) unionset[i]=i;//init
	        for(int i=0;i<edges.length;i++){//if exists a circle the union will return false!-> already connected!
	            if(!union(unionset,Math.min(edges[i][0],edges[i][1]),Math.max(edges[i][0],edges[i][1]))) return false;
	        }
	        for(int i =1;i<unionset.length;i++){//use find method to check if they are connected.
	            if(find(unionset,unionset[i])!=find(unionset,unionset[i-1]))  return false;
	        }
	        return true;
	    }
	    public int find(int [] arr, int x){
	        if(arr[x]==x)
				return x;
			else return find(arr,arr[x]);
	    }
		public boolean union(int [] union, int x , int y){
			int xroot= find(union,x);
			int yroot= find(union,y);
			if(xroot==yroot) return false;
			union[yroot]=xroot;
			return true;
		}
	}
	public static void main(String args[]){
		GraphValid gv= new GraphValid();
		int [][]edges={{0, 1}, {2, 0}};
		System.out.println(gv.validTree(3,edges));
	}
}