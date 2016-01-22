/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.




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
