// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");
class Tree{
	int x;
	Tree l;
	Tree r;
}
public class VisibleTreeNodes {
    static int count=0;
    public int solution(Tree T) {
        // write your code in Java SE 8
        if(T==null)
            return 0;
        int minValue=T.x;
        
        dfs(T,minValue);
        return count;
    }
    public static void dfs(Tree T, int min){
        if(T==null)
            return;
        if(T.x>=min){
            count++;
            min=T.x;
        }
        int temp=min;
        dfs(T.l,temp);
        dfs(T.r,temp);
    }
}
