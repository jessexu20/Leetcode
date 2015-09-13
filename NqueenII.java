import java.util.*;
public class NqueenII {
	int count =0;
    public int totalNQueens(int n) {
       	int [] temp= new int[n];
		for(int i=0;i<n;i++)
			temp[i]=-1;
		for(int i=0;i<n;i++){
			step(temp,i);
		}
		return count;
    }
	public void step(int [] array,int i){
		if(i==array.length){
			for(int pos: array){
				if(pos==-1)
					return;
			}
			count++;
			return;
		}	
		for(int k=0;k<array.length;k++){
			if(check(array,i,k)){
				int [] temparray=array.clone();
				temparray[i]=k;
				step(temparray,i+1);
			}
		}
	}
	public boolean check(int [] array,int i,int j ){
		if(array[i]!=-1)
			return false;
		for(int k=0;k<array.length;k++){
			if(k==i)
				continue;
			if(array[k]==j)
				return false;
			if(array[k]!=-1 && Math.abs(array[k]-j)==Math.abs(k-i))
				return false;
		}
		return true;
		
	}
	public static void main(String args[]){
		NqueenII nq=new NqueenII();
		System.out.println(nq.totalNQueens(4));
	}
}