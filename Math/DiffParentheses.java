import java.util.*;
public class DiffParentheses {
	HashMap<String, List<Integer>> cache = new HashMap();
    public List<Integer> diffWaysToCompute(String input) {
        List <Integer>result= new ArrayList<Integer>();
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)=='+'||
				input.charAt(i)=='-'||
			input.charAt(i)=='*'){
				String part1=input.substring(0,i);
				String part2=input.substring(i+1,input.length());
				List<Integer> part1Ret=diffWaysToCompute(part1);
				List<Integer> part2Ret=diffWaysToCompute(part2);
				for(int x:part1Ret){
					for (int y: part2Ret){
						int temp=0;
						switch(input.charAt(i)){
							case '+': temp=x+y;break;
							case '-': temp=x-y;break;
							case '*': temp=x*y;break;
						}
						result.add(temp);
					}
				}
			}
		}
		if(result.size()==0){
			result.add(Integer.valueOf(input));
		}
		cache.put(input,result);
		return result;
    }
	public static void main(String args[]){
		DiffParentheses dp= new DiffParentheses();
		String str="2*3-4*5";
		System.out.println(dp.diffWaysToCompute(str));
		// System.out.println(dp.cache);
	}
}