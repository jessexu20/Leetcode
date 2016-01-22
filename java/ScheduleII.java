import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;

public class ScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
		if(prerequisites.length<1){
			int [] r= new int[numCourses];
			for (int i=0;i<numCourses;i++)
				r[i]=i;
			return r;
		}
		List<List<Integer>> adlist=new ArrayList();
		int [] indegree=new int[numCourses];
		int [] result=new int [numCourses];
		Queue<Integer>q=new LinkedList();
		for(int i=0;i<numCourses;i++){
			adlist.add(new ArrayList<Integer>());
		}
		for(int i=0;i<prerequisites.length;i++){
			int st=prerequisites[i][0];
			int ed=prerequisites[i][1];
			if(!adlist.get(st).contains(ed))
				indegree[ed]++;
			adlist.get(st).add(ed);
		}
		for(int i=0;i<indegree.length;i++){
			// System.out.print(indegree[i]);
			if(indegree[i]==0){
				q.offer(i);
			}
		}
		int count =0;
		while(!q.isEmpty()){
			int point=q.poll();
			result[count]=point;
			count++;
			List <Integer> temp=adlist.get(point);
			for(int i=0;i<temp.size();i++){
				if(--indegree[temp.get(i)]==0)
					q.offer(temp.get(i));
			}
		}
		if(count==numCourses){
			for (int i = 0; i < result.length / 2; i++) {
			  int temp = result[i];
			  result[i] = result[result.length - 1 - i];
			  result[result.length - 1 - i] = temp;
			}
			return result;
		}
		else
			return new int[0];
	}
	public static void main(String args[]){
		ScheduleII s= new ScheduleII();
		int [][] pre={{1,0}};
		int [] result=s.findOrder(5,pre);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]);
		}
	}
}