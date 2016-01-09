import java.util.*;
class Point{
	int x;
	int y;
	Point(int a, int b){
		x = a;
		y = b;
	}
}
class Vector{
	int x;
	int y;
	Vector(int a, int b){
		x = a;
		y = b;
	}
}
public class DetectSquare{
	int para = 0, orth = 0, len = 0;
	public boolean isSquare(Point [] points){
		if(points.length != 4) return false;
		Vector [] v = new Vector[6];
		Point a = points[0];
		int j = 0;
		for(int i = 1; i < points.length; i++){
			Point b = points[i];
			Point [] left = findLeft(b,points);
			Vector m = new Vector(a.x-b.x,a.y-b.y);
			Vector n = new Vector(left[0].x - left[1].x, left[0].y - left[1].y);
			v[j++] = m;
			v[j++] = n;
		}
		for(int i = 0; i < v.length; i+=2){
				if(v[i].x*v[i+1].x+v[i].y+v[i+1].y==0) orth++;
				if(v[i].x*v[i+1].y==v[i].y*v[i+1].x) para++;
				if(v[i].x*v[i].x+v[i].y*v[i].y == v[i+1].x*v[i+1].x+v[i+1].y*v[i+1].y) len++;
		}
		return (orth==1 && para==2 && len ==3);
	}
	private Point[] findLeft(Point p, Point [] points){
		Set<Point> set = new HashSet<Point> ();
		for(int i = 1; i< points.length; i++) set.add(points[i]);
		set.remove(p);
		int j = 0;
		Point [] result = new Point[set.size()];
		for(Point x:set){
			result[j++] = x;
		}
		return result;
	}
	public static void main(String args[]){
		Point a = new Point(0,0);
		Point b = new Point(0,2);
		Point c = new Point(1,0);
		Point d = new Point(1,1);
		Point [] p = {a,b,c,d};
		DetectSquare ds = new DetectSquare();
		System.out.println(ds.isSquare(p));
	}
}