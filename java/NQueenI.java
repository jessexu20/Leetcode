import java.util.*;
public class NQueenI {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result= new ArrayList();
		generate(result,new ArrayList<String>(),n);
		return result;
    }
    public void generate(List<List<String>> result, List<String> list, int n){
        if(list.size()==n){
            result.add(list);
            return;
        }
        for(int i =0; i <n;i++){
			char [] dots= new char[n];
			Arrays.fill(dots,'.');
            StringBuilder t=new StringBuilder(String.valueOf(dots));
            if(valid(list,i,n)){
                t.setCharAt(i,'Q');
                List<String> temp= new ArrayList(list);
                temp.add(t.toString());
                generate(result,temp,n);
            }
        }
    }
    public boolean valid(List<String> list,int index,int n){
        for(int i =0;i<list.size();i++){
            String str=list.get(i);
            if(str.charAt(index)=='Q') return false;
            if(index-list.size()+i >=0 && str.charAt(index-list.size()+i)=='Q') return false;
            if(index+list.size()-i <n && str.charAt(index+list.size()-i)=='Q') return false;
        }
        return true;
    }
	public static void main(String args[]){
		NQueenI nq=new NQueenI();
		System.out.println(nq.solveNQueens(8));
	}
}