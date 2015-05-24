public class BitAnd {
    public int rangeBitwiseAnd(int m, int n) {
        int xmask = m ^ n;
        int mlen = 0;
        int mask;
		// System.out.println(xmask);
        if ((xmask >> (mlen + 16)) > 0) mlen += 16;
        if ((xmask >> (mlen + 8)) > 0) mlen += 8;
        if ((xmask >> (mlen + 4)) > 0) mlen += 4;
        if ((xmask >> (mlen + 2)) > 0) mlen += 2;
        if ((xmask >> (mlen + 1)) > 0) mlen ++;

        mask = ~0 << mlen;
		// System.out.println(mask);
        return m & mask;
    }
	public static void main(String args[]){
		BitAnd ba= new BitAnd();
		System.out.println(ba.rangeBitwiseAnd(5,7));
	}
}