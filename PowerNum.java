package leetcode;

public class PowerNum {
	public double calculator(double x, int n) {
		if (n == 1) {
			return x;
		} else if (n % 2 != 0) {
			double temp = pow(x, n / 2);
			return temp * temp * x;
		} else {
			double temp = pow(x, n / 2);
			return temp * temp;
		}

	}

	public double pow(double x, int n) {
		boolean postive = true;
		if (n > 0) {
			postive = true;
		} else if (n == 0) {
			return 1;
		} else {
			postive = false;
		}
		n = Math.abs(n);
		double ans = calculator(x, n);
		if (postive) {
			return ans;
		} else {
			return 1 / ans;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerNum powerNum = new PowerNum();
		System.out.println(powerNum.pow(2, -1));
	}
}
