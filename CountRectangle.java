import java.util.*;
class Point implements Comparable<Point>{
	int x;
	int y;
	Point(int a, int b){
		x = a;
		y = b;
	}
	public int compareTo(Point p){
		return this.x - p.x;
	}
}
public class CountRectangle{
	public int count(Point[] points){
		HashMap<String, List<Integer>> map = new HashMap<>();
		Arrays.sort(points);
		for(int i = 0; i < points.length; i++){
			int j = i;
			while(j < points.length && points[j].x == points[i].x)
				j++;
			for(int k = i; k < j; k++){
				for(int m = k+1; m < j; m++){
					String t = points[k].y + "->" + points[m].y;
					if(!map.containsKey(t))
						map.put(t,new ArrayList<Integer>());
					map.get(t).add(points[k].x);
				}
			}
			i = j-1;
		}
		int cnt = 0; 
		for(String key: map.keySet()){
			int num = map.get(key).size();
			if(num>1){
				cnt += (num*(num-1)/2);
			}
		}
		return cnt;
	}
	public static void main(String args[]){
		CountRectangle cr = new CountRectangle();
		Point [] points = {new Point(0,1),new Point(0,2),new Point(1,0),new Point(1,2), new Point(2,0), new Point(2,1), new Point(3,0),new Point(3,1),new Point(3,2)};
		System.out.println(cr.count(points));
	}
}