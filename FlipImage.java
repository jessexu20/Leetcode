public class FlipImage {
	// private static final byte[] LOOKUP_ARRAY = INIT_LOOKUP_ARRAY();
	// private static byte[] INIT_LOOKUP_ARRAY() {
	// // Some code here
	// return new byte[256];
	// }
	public void flipImage(byte[] img, int width, int height){
		System.out.println(reverseBitsByte((byte)0b00001011));//11010000 = -128 + 64 + 16 = -48
	}
	public byte reverseBitsByte(byte x) {
		int intSize = 8;
		byte y=0;
		for(int position=intSize-1; position>0; position--){
			y+=((x&1)<<position);
			x >>= 1;
		}
		return y;
	}
	public static void main(String args[]){
		FlipImage fi = new FlipImage();
		byte [] img = {(byte)0b01110011,(byte)0b11010110,(byte)0b00001111,(byte)0b11110000};
		fi.flipImage(img,8,4);
	}
}