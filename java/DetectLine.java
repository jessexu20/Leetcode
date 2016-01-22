import java.util.*;
class Point{
	int x;
	int y;
	Point(int a, int b){
		x = a;
		y = b;
	}
}
public class DetectLine{
	public boolean detect(List<Point> list){
		double xpos = 0;
		Set<Integer> ypos = new HashSet();
		for(Point p : list){
			xpos += p.x;
		}
		xpos= xpos/list.size();
		for(Point p : list){
			if(p.x==xpos) continue;
			if(!ypos.add(p.y)){
				ypos.remove(p.y);
			}
			xpos += p.x;
		}
		System.out.println(xpos);
		if(ypos.size()>0) return false;
		else return true;
	}
	public static void main(String args[]){
		DetectLine dl = new DetectLine();
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(1,2));
		list.add(new Point(1,2));
		list.add(new Point(1,2));
		list.add(new Point(1,3));
		System.out.println(dl.detect(list));
		
	}
}