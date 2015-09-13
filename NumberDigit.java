public class NumberDigit {
	public int countDigitOne(int n) {
	    int ones = 0;
	    for (long m = 1; m <= n; m *= 10)
	        ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
	    return ones;
	}
	public static void main(String args[]){
		NumberDigit nd = new NumberDigit();
		System.out.println(nd.countDigitOne(19));
	}
}
//15 10 1 6