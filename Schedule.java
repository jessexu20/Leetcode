import java.util.*;
public class Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses<2 || prerequisites.length<2)
			return true;
		int [][] matrix=new int [numCourses][numCourses];
		int [] indegree=new int[numCourses];
		Queue<Integer>q=new LinkedList();
		for(int i=0;i<prerequisites.length;i++){
			int st=prerequisites[i][0];
			int ed=prerequisites[i][1];
			if(matrix[st][ed]==0)
				indegree[ed]++;
			matrix[st][ed]=1;
			
		}
		for(int i=0;i<indegree.length;i++){
			if(indegree[i]==0){
				q.offer(i);
			}
		}
		int count =0;
		while(!q.isEmpty()){
			int point=q.poll();
			count++;
			for(int i=0;i<numCourses;i++){
				if(matrix[point][i]!=0){
					if(--indegree[i]==0)
						q.offer(i);
				}
			}
		}
		return count==numCourses;
	}
	public static void main(String args[]){
		Schedule s= new Schedule();
		int [][] pre={{1,0},{0,2},{2,1}};
		System.out.println(s.canFinish(3,pre));
	}
}