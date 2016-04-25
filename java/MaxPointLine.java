import java.util.*;
class Point{
	int x;
	int y;
	Point(int a, int b){
		x = a;
		y = b;
	}
}
//ax + by = c
class Tuple{
	int a;
	int b;
	Tuple(int x, int y){
		a = x;
		b = y;
	}
	public int hashCode(){
		return this.toString().hashCode();
	}
	public String toString(){
		return (a+","+b);
	}
	public boolean equals(Object obj){
		return this.toString().equals(obj.toString());
	}
}
public class MaxPointLine{
	public int gcd(int m, int n){
		if(m%n==0)
			return n;
		else return gcd(n,m%n);
	}
	int max = 0;
	int max_c = 0;
	Tuple maxTuple = null;
	public int[] findLine(Point [] points){
		HashMap<Tuple, HashMap<Integer,Integer>> map = new HashMap<>();
		for(int i = 0; i < points.length; i++){
			for(int j = i; j < points.length; j++){
				//ax1+ by1 = c
				//ax2+ by2 = c
				//(x2-x1) a + b(y2-y1) = 0;
				//b/a = k
				//a = dist_x/gcd , b = dist_y/gcd, c = ax1/gcd+by1/gcd
				int dist_y = points[j].y - points[j].y;
				int dist_x = points[j].x - points[i].x;
				int g = gcd(dist_x,dist_y);
				Tuple t = new Tuple(dist_x/g,dist_y/g);
				int c = dist_x/g * points[i].x + dist_y/g * points[i].y;
				if(!map.containsKey(t))
					map.put(t,new HashMap<Integer,Integer>());
				if(!map.get(t).containsKey(c))
					map.get(t).put(c,0);
				map.get(t).put(c,map.get(t).get(c)+1);
				if(map.get(t).get(c)> max){
					max = map.get(t).get(c);
					maxTuple = t;
					max_c = c;
				}
			}
		}
		return new int []{maxTuple.a,maxTuple.b,max_c};
	}
	public static void main(String args[]){
		MaxPointLine line = new MaxPointLine();
		
		System.out.println(line.gcd(8,12));
	}
}