import java.util.*;
public class RandomGen{
	public int rand2(){
		Random random = new Random();
		return random.nextInt(2);
	}
	public int rand6(){
		int number = -1;
		while(number < 0 || number > 5){
			number = 4 * rand2() + 2 * rand2() + rand2();
		}
		return number;
	}
	public int rand7(){
		int number = -1;
		while(number < 0 || number > 6){
			number  = 6 * rand6() + rand6();
		}
		return number;
	}
	public static void main(String args[]){
		RandomGen r = new RandomGen();
		int [] cnt = new int[6];
		for(int i = 0; i < 10000;i++)
			cnt[r.rand6()]++;
			// System.out.println(r.rand7());
		for(int i = 0; i < 6; i++){
			System.out.print(cnt[i]+"\t");
		}
	}
}