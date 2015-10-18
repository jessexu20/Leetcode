/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
class Reader4{
	public int read4(char [] buf){
		return 0;
	}
}
public class Read4 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
		int bufCnt,bufPtr=0;
	char [] buf4;
    public int read(char[] buf, int n) {
		int count = 0;
		while(count < n){
			if(bufPtr==0){
				bufCnt=read4(buf4);// read 4 byte
			}
			if(bufCnt==0) break;//empty file
			while(bufPtr<bufCnt && count<n){
				buf[count++]=buf4[bufPtr++];//read into buf
			}
			if(bufPtr==bufCnt) bufPtr=0;//reset pointer pos
		}
    }
}
