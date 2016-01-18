package google;

public class FloatDivison {
	public float divide(float a, float b, int c) {
		int ten = 0;
		while (a % 1 != 0 && b % 1 != 0) {
			a *= 10;
			b *= 10;
		}
		while (a % 1 != 0)
			ten++;
		while (b % 1 != 0)
			ten--;
		long dividend = (long) a;
		long divisor = (long) b;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		boolean sign = (a * b > 0) ? true : false;
		long partial = helper(dividend, divisor);
		float answer = (float) partial / (float) Math.pow(10, ten);
		long left = dividend - partial * divisor;
		int i = 1;
		while (i < c && left > 0) {
			partial = helper(left * 10, divisor);
			left = left * 10 - divisor * partial;
			answer += ((float) partial / (int) Math.pow(10, i));
			i++;
		}
		return sign ? answer : -1 * answer;
	}

	private long helper(long dividend, long divisor) {
		long cnt = 0;
		long temp = divisor;
		long ans = 0;
		while (dividend - temp > 0) {
			while (dividend - temp > 0) {
				cnt += (1 << ans);
				dividend -= temp;
				temp <<= 1;
				ans++;
			}
			temp = divisor;
			ans = 0;
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float a = 1.5f;
		float b = 0.7f;
		FloatDivison floatDivison = new FloatDivison();
		System.out.println(floatDivison.divide(a, b, 3));
	}

}
