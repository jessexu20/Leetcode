package google;

import java.util.*;

public class SideWalk {

	public int countTime() {
		boolean[] sidewalk = new boolean[100];
		Random random = new Random();
		int cnt = 0;
		int time = 0;
		while (cnt < 100) {
			time++;
			int number = random.nextInt(100);
			if (!sidewalk[number]) {
				sidewalk[number] = true;
				cnt++;
			}
		}
		return time;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SideWalk sideWalk = new SideWalk();
		System.out.println(sideWalk.countTime());
	}

}
