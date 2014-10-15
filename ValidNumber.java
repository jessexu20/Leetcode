package Leetcode;

public class ValidNumber {
	public boolean notaNumber(char num){
		if (num>'9' || num<'0') {
			return true;
		}
		else return false;
	}
	public boolean specialSymbol(char symbol){
		if (symbol=='.'||symbol=='+'||symbol=='-') {
			return true;
		}
		else return false;
	}
    public boolean isNumber(String s) {
    	boolean pointflag=false;
    	boolean eflag=false;
    	s=s.trim();
    	int len=s.length();
    	if (len==0)
    	    return false;
    	char first=s.charAt(0);
    	if (specialSymbol(first) && len==1)
    		return false;
    	if (notaNumber(first) && !specialSymbol(first))
    		return false;
    	else if (specialSymbol(first)){
    		if (first!='.'){
    			if (notaNumber(s.charAt(1)) && s.charAt(1)!='.')
    				return false;
		    	s=s.substring(1);
		    	len=s.length();
		   		// System.out.println(s);
				first=s.charAt(0);
		    	if (specialSymbol(first) && len==1)
		    		return false;
    		}
    	}
		for (int i=0;i<len;i++){
			if (notaNumber(s.charAt(i))) {
				if (s.charAt(i)!='e' && s.charAt(i)!='.') {
						return false;
				}
			}
			if (pointflag && s.charAt(i)=='.') {
				return false;
			}
			if (s.charAt(i)=='.' ){
				pointflag=true;
				if (i+1<len && s.charAt(i+1)=='.')
					return false;
			}
			if (eflag && s.charAt(i)=='e') {
				
				return false;
			}
			if (s.charAt(i)=='e'){
				eflag=true;
				if (i+1>=len) {
					return false;
				}
				if (notaNumber(s.charAt(i+1)))
					return false;
			}	
		}
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumber validNumber=new ValidNumber();
		System.out.println(validNumber.isNumber("46.e3"));	
	}
}
