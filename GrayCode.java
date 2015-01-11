package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> arrayList = new ArrayList<>();
		int totalNum = (int) Math.pow(2, n);
		for (int i = 0; i < totalNum; i++) {
			int code = i ^ (i / 2);
			arrayList.add(code);
		}
		return arrayList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode gray = new GrayCode();
		System.out.println(gray.grayCode(2));
	}

}
