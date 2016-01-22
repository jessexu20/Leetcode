import java.util.*;
class People{
	String name;
	int height;
	int pos;
	People(String str, int h, int p){
		name = str;
		height = h;
		pos = p;
	}
}
public class RecoverQueue{
	public List<People> recover(List <People> list){
		Collections.sort(list,new Comparator<People>(){
			public int compare(People p1, People p2){
				if(p1.pos<p2.pos) return -1;
				else if(p1.pos>p2.pos) return 1;
				else{
					return p1.height - p2.height;
				}
			}
		});
		List<People> result = new ArrayList<People>();
		for(int i = 0; i< list.size();i++){
			People temp = list.get(i);
			if(result.size()==0 || temp.pos == 0){
				result.add(temp);
				continue;
			}
			int count = 0,j=0;
			for(j = 0;j<result.size();j++){
				if(result.get(j).height>temp.height) count++;
				if(count == temp.pos) break;
			}
			result.add(j+1,temp);
		}
		return result;
	}
	public static void main(String args[]){
		RecoverQueue rq = new RecoverQueue();
		List <People> list = new ArrayList<People>();
		list.add(new People("a",5,0));
		list.add(new People("b",4,0));
		list.add(new People("c",3,1));
		list.add(new People("d",2,3));
		list.add(new People("e",1,4));
		List<People> result = new ArrayList<People>(rq.recover(list));
		for(People p : result){
			System.out.print(p.name+"\t");
		}
	}
}