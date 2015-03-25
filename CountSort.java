import java.util.*;
class People{
	int rate;
	String name;
	public People() {
		// TODO Auto-generated constructor stub
		rate=(int) (Math.random()*255);
		name=Integer.toString(rate);
	}
}
public class CountSort {
	public void countSort(int [] arr){
		int bucket[] =new int[256];
		for (int i : arr) {
			bucket[i]++;
		}
		int j=0;
		for (int i = 0; i < bucket.length; i++) {
			while (bucket[i]>0) {
				arr[j]=i;
				j++;
				bucket[i]--;
				if (j>=arr.length) {
					break;
				}
			}

		}
	}
	public void countSort(People [] arr){
		ArrayList<ArrayList<People>> bucket= new ArrayList();
		for (int i = 0; i < 256; i++) {
			bucket.add(new ArrayList<People>());
		}
		for (int i = 0; i < arr.length; i++) {
			bucket.get(arr[i].rate).add(arr[i]);
		
		}
		int j=0;
		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i).size()>0) {
				for (People people : bucket.get(i)) {
					arr[j]=people;
					j++;
					if (j>=arr.length) {
						break;
					}
				}

			}

		}
	}
	public static void main(String args[]){
		CountSort cs=new CountSort();
		int [] arr=new int[100];
		
		for (int i=0;i<arr.length;i++) {
			arr[i]=(int) (Math.random()*255);
		}
		cs.countSort(arr);
//		for (int i : arr) {
//			System.out.print(i+"\t");
//		}
		People p1=new People();
		People p2=new People();
		People p3=new People();
		People p4=new People();
		People p5=new People();
		People p6=new People();
		People [] peoples={p1,p2,p3,p4,p5,p6};
		cs.countSort(peoples);
		for (People people : peoples) {
			System.out.print(people.name+"\t");
		}
	}
}
