import java.util.*;
public class NqueenII {
    int count=0;
    public int totalNQueens(int n) {
        int [] arr= new int [n];//store the location of queen into the array..
        Arrays.fill(arr,-1);
        generate(arr,n,0);
        return count;
    }
    public void generate(int [] arr,int n,int cur){
        if(cur==arr.length){
            if(arr[arr.length-1]!=-1)
                count++;
            return;
        }
        for(int i=0;i<n;i++){
            if(valid(arr,cur,i)){
                arr[cur]=i;
                generate(arr,n,cur+1);//get to next level
            }
            arr[cur]=-1;//remove current influence.
        }
    }
    public boolean valid(int [] arr, int index,int value){
        for(int i=0;i<index;i++){
            int d=value-arr[i];
            if(Math.abs(d)==0 || Math.abs(d)==Math.abs(index-i)) return false;
        }
        return true;
    }
	public static void main(String args[]){
		NqueenII nq=new NqueenII();
		System.out.println(nq.totalNQueens(4));
	}
}