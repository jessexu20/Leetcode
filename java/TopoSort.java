import java.util.*;
public class TopoSort {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] degree= new int [numCourses];
		for(int i=0;i<prerequisites.length;i++){
			degree[prerequisites[i][1]]++;
		}
		Queue<Integer> que= new LinkedList<Integer>();
		int []result=new int [numCourses];
		int j=numCourses-1;
		for(int i=0;i<degree.length;i++){
			if(degree[i]==0)
				que.offer(i);
		}
		while(!que.isEmpty()){
			int p=que.poll();
			result[j--]=p;
			for(int i=0;i<prerequisites.length;i++){
				if(prerequisites[i][0]==p){
					degree[prerequisites[i][1]]--;
					if(degree[prerequisites[i][1]]==0)
						que.offer(prerequisites[i][1]);
				}
			}
		}
		if(j>0)
		    return new int [0];
		return result;
    }
	public static void main(String []args){
		TopoSort ts= new TopoSort();
		int edge[][]={
			{1,0},{2,0},{3,1},{3,2}
		};
		int [] result=ts.findOrder(4,edge);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
}