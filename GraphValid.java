public class GraphValid {
    public boolean validTree(int n, int[][] edges) {
        int [] unionset= new int [n];
        for(int i =0;i<unionset.length;i++) unionset[i]=i;
        for(int i=0;i<edges.length;i++){
            if(!union(unionset,Math.min(edges[i][0],edges[i][1]),Math.max(edges[i][0],edges[i][1]))) return false;
        }
		for(int j =0;j<unionset.length;j++) System.out.print(unionset[j]+"\t");
		System.out.println();
        for(int i =1;i<unionset.length;i++){
            if(unionset[i]!=unionset[i-1] && find(unionset,unionset[i])!=unionset[i-1]) return false;
        }
        return true;
    }
    public int find(int [] union, int x){
        if(union[x]==x)
			return x;
		else return find(union,union[x]);
    }
	public boolean union(int [] union, int x , int y){
		int xroot= find(union,x);
		int yroot= find(union,y);
		if(xroot==yroot) return false;
		else union[yroot]=xroot;
		return true;
	}
	public static void main(String args[]){
		GraphValid gv= new GraphValid();
		int [][]edges={{0, 1}, {2, 0}};
		System.out.println(gv.validTree(3,edges));
	}
}