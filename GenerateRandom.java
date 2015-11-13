import java.util.*;
public class GenerateRandom{
	List<Integer> ids;
	List<Double> prob;
	int [] counter;
	static int count = 0;
	GenerateRandom(List<Integer> dat, List<Double> p){
		ids = new ArrayList(dat);
		prob = new ArrayList(p);
		counter = new int [dat.size()];
	}
	public static int random(){
		Random rand = new Random();
		count++;
		int r = rand.nextInt(ids.size());
		while(counter[r]>count*prob.get(r))
			r = rand.nextInt(dat.size());
		return ids.get(r);
	}
	public static void main(String args[]){
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		List<Double> prob = new ArrayList<Double>();
		prob.add(0.2);
		prob.add(0.2);
		prob.add(0.2);
		prob.add(0.2);
		prob.add(0.2);
		GenerateRandom gr = new GenerateRandom(nums,prob);
		List<Integer> test = new ArrayList();
		for(int i = 0; i<100;i++){
			test.add(gr.random());
		}
		System.out.println(test);
	}
}