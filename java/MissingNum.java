import java.util.*;
public class MissingNum{
	public List<List<Integer>> findIntervals(List<Integer> list){
		List<List<Integer>> result= new ArrayList<List<Integer>>();
		int m=0,n=0;
		int max=0;
		boolean start=true;
		for(int i=0;i<100;i++){
			if(!list.contains(i)&& start){
				m=i;
				start=false;
			}
			if(list.contains(i)&& !start){
				n=i;
				start=true;
				List<Integer> part= new ArrayList();
				part.add(m);part.add(n-1);
				result.add(part);
			}
			if(list.contains(i))
				max=i;
		}
		System.out.println(max);
		
		if(max!=99){
			List<Integer> part= new ArrayList();
			part.add(max+1);
			part.add(99);
			result.add(part);
		}
		return result;
	}
	public static void main(String args[]){
			MissingNum mn=new MissingNum();
			List<Integer> list= new ArrayList();
			// list.add(0);
			// list.add(100);
			list.add(2);
			list.add(50);
			list.add(84);
			// list.add(99);
			System.out.println(mn.findIntervals(list));
	}
}