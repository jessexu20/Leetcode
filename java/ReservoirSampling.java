import java.util.*;
public class ReservoirSampling{
	static int temp = 0;
	static int count;
	public static int generate(){
		return temp;
	}
	public static void add(int num){
		Random random = new Random();
		double r = random.nextDouble();
		count++;
		if(r>(double)1.0/count) temp = num;
	}
	public static void main(String args[]){
		ReservoirSampling rs = new ReservoirSampling();
		for(int i = 0; i < 1000; i++ ){
			rs.add(i);
			if(i % 10==0) System.out.println(rs.generate());
		}
	}
}