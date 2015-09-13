import java.util.*;
public class Nqueen {
    public List<List<String>> solveNQueens(int n) {
		List<List<String>> res=new ArrayList();
       	int [] temp= new int[n];
		for(int i=0;i<n;i++)
			temp[i]=-1;
		for(int i=0;i<n;i++){
			step(temp,i,res);
		}
		return res;
    }
	public void step(int [] array,int i,List<List<String>>res){
		if(i==array.length){
			List<String>list =new ArrayList<String>();
			for(int pos: array){
				if(pos==-1)
					return;
				String str="";
				for(int k=0;k<array.length;k++){
					if(k!=pos)
						str+=".";
					else str+="Q";
				}
				list.add(str);
			}
			res.add(list);
			return;
		}	
		for(int k=0;k<array.length;k++){
			if(check(array,i,k)){
				int [] temparray=array.clone();
				temparray[i]=k;
				step(temparray,i+1,res);
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
		Nqueen nq=new Nqueen();
		System.out.println(nq.solveNQueens(9));
	}
}