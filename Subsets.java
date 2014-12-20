import java.util.*;
public class Subsets{
	public void traverse(List<List<Integer>> result,List<Integer> set,int index,List<Integer>num){
		if(!result.contains(set)){
			result.add(set);
		}
		for(int i=index;i<num.size();i++){
			List<Integer> temp=new ArrayList(set);
			if(!temp.contains(num.get(i))){
				if(temp.size()>=1){
					if(num.get(i)>temp.get(temp.size()-1)){
						temp.add(num.get(i));
						traverse(result,temp,index+1,num);
					}	
				}
				else{
					temp.add(num.get(i));
					traverse(result,temp,index+1,num);
				}
				
			}
		}
	}
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result=new ArrayList<List<Integer>> ();
		List<Integer> num=new ArrayList<Integer>();
		for(int i=0;i<S.length;i++){
			num.add(S[i]);
		}
		Collections.sort(num);
		traverse(result,new ArrayList<Integer>(),0,num);
		return result;
    }
	public static void main(String args[]){
		Subsets s= new Subsets();
		int [] num={1,0,1};
		System.out.println(s.subsets(num));
		
	}
}