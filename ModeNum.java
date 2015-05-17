// you can also use imports, for example:
// import java.util.*;
import java.util.Arrays;
// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class ModeNum {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int length=0;
        int maxLength=Integer.MIN_VALUE;
        if(A.length<1)
            return 0;
        if(A.length==1)
            return A[0];
        int temp=0;
        int num=0;
        for(int i=1;i<A.length;i++){
           if(length==0){
              if(A[i]==A[i-1]){
                  temp=A[i];
                  length++;
              }
           }
           else {
               if(A[i]!=temp){
                if(length>maxLength){
                    maxLength=length;
                    num=temp;
                }
                length=0;
               }
               
           }
        }
        if(maxLength==Integer.MIN_VALUE && length!=0)
            num=temp;
        return num;
    }
}
