import java.util.*;
class Point{
	int x;
	int y;
	Point(int a, int b){
		x = a;
		y = b;
	}
}
public class SymmetricPoints{
	public boolean isSymmetric(Point [] points){
		HashMap<Integer, Integer> map = new HashMap<>();
		double avg = 0;
		for(Point p : points){
			avg += p.x;
		}
		avg /= points.length;
		for(Point p: points){
			if(p.x!=avg){
				if(!map.containsKey(p.y))
					map.put(p.y,0);
				map.put(p.y,map.get(p.y)+1);
			}
		}
		for(int key: map.keySet()){
			if(map.get(key)%2!=0)
				return false;
		}
			
		return true;
	}
	public static void main(String args[]){
		SymmetricPoints sp = new SymmetricPoints();
		Point [] points = new Point[10];
		points[0] = new Point(1,2); 
		points[1] = new Point(1,3); 
		points[2] = new Point(1,4); 
		points[3] = new Point(3,2); 
		points[4] = new Point(-1,2); 
		points[5] = new Point(3,4); 
		points[6] = new Point(-1,4); 
		points[7] = new Point(8,2); 
		points[8] = new Point(-6,2); 
		points[9] = new Point(1,0);
		System.out.println(sp.isSymmetric(points));
	}
}