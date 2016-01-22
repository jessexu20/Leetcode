/*The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Read4Multi extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char [] buf4=new char [4];
    int bufIndex=0;
    int bufCnt=0;
    public int read(char[] buf, int n) {
        int count = 0;
        while(count<n){
            if(bufIndex==0){
                bufCnt = read4(buf4);
            }
            if(bufCnt==0) break;
            
            while(bufIndex<bufCnt && count < n)
                buf[count++]=buf4[bufIndex++];
            if(bufIndex==bufCnt){
                bufIndex = 0;
            }
        }
        return count;
    }
}