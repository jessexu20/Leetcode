import java.util.*;
class Url{
	String name;
	double score;
	Url(String n, double s){
		name = n;
		score = s;
	}
}
public class OrderUrl{
	public List<Url> merge(List<Url> a, List<Url> b){
		Set<String> visited = new HashSet();
		List<Url> result = new ArrayList();
		int i = 0, j = 0;
		while(i < a.size() || j < b.size()){
			if(i == a.size())
				add(b.get(j++),visited,result);
			
			else if(j == b.size())
				add(a.get(i++),visited,result);
			
			else{
				if(a.get(i).score>b.get(j).score)
					add(a.get(i++),visited,result);
				
				else
					add(b.get(j++),visited,result);
				
			}
		}
		return result;
	}
	private void add(Url url, Set<String>visited, List<Url> result){
		if(visited.add(url.name)){
			result.add(url);
		}
	}
	public static void main(String args[]){
		OrderUrl order = new OrderUrl();
		List<Url> a = new ArrayList();
		List<Url> b = new ArrayList();
		Url u1 = new Url("u1",0.9);
		Url u2 = new Url("u2",0.8);
		Url u3 = new Url("u3",0.75);
		Url u4 = new Url("u1",0.8);
		Url u5 = new Url("u3",0.6);
		Url u6 = new Url("u4",0.5);
		a.add(u1);
		a.add(u2);
		a.add(u3);
		b.add(u4);
		b.add(u5);
		b.add(u6);
		List<Url> result = order.merge(a,b);
		for(Url url : result){
			System.out.print(url.name+"\t");
		}
		System.out.println();
		for(Url url : result){
			System.out.print(url.score+"\t");
		}
		
	}
}