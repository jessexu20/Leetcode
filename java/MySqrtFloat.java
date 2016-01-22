package google;

public class MySqrtFloat {
	public double sqrt(double number) {
		double t;
		double squareRoot = number / 2;
		do {
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2;
		} while ((t - squareRoot) != 0);

		return squareRoot;
	}
	public double sqrt2(double n) {

	    double low = 0;
	    double high = n;
	    double mid = (high - low) / 2;

	    while (Math.abs((mid * mid) - n) > 0.000000000001) {
	        if (mid > n/mid) {

	            high = mid;
	            mid = (high - low) / 2;

	        } else{

	            low = mid;
	            mid = mid + ((high - low) / 2);

	        }
	    }
	    return mid;
	}
	public static void main(String args[]) {
		MySqrtFloat s = new MySqrtFloat();
		long time1 = System.currentTimeMillis();
		System.out.println(s.sqrt(1500000000));
		System.out.println(System.currentTimeMillis()-time1);
		time1= System.currentTimeMillis();
		System.out.println(s.sqrt2(1500000000));
		System.out.println(System.currentTimeMillis()-time1);
	}
}
