import java.util.*;
public class AddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<String>();
		for(int i=1;i<=num.length();i++){
			String left=num.substring(0,i);
			long leftVal=Long.valueOf(left);
			if(!(leftVal + "").equals(left)) break;//get rid of starting 0
			calculate(num,i,target,res,'#',leftVal,leftVal,left);
		}
		return res;
    }
	public void calculate(String num, int index, int target,List<String> result,char sign,long leftValue,long prevValue,String leftString){
		if((index==num.length()) &&leftValue==target){
			result.add(leftString);
			return;
		}
		for(int i =index+1;i <= num.length();i++){
			String right=num.substring(index,i);
			long rightVal=Long.valueOf(right);
			if(!(rightVal + "").equals(right)) return;//get rid of starting 0
			calculate(num,i,target,result,'+',leftValue+rightVal,rightVal,leftString+"+"+right);
			calculate(num,i,target,result,'-',leftValue-rightVal,rightVal,leftString+"-"+right);
			long newLeft=0;
			if(sign=='+') newLeft=leftValue-prevValue+prevValue*rightVal;
			else if(sign=='-') newLeft=leftValue+prevValue-prevValue*rightVal;
			else newLeft=prevValue*rightVal;
			calculate(num,i,target,result,sign,newLeft,prevValue*rightVal,leftString+"*"+right);
		}
	}
	public static void main(String[] args){
		AddOperators ao=new AddOperators();
		String str="123";
		int target=6;
		System.out.println(ao.addOperators(str,target));
	}
}