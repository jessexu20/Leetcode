public class ValidNumber {
    public boolean isNumber(String s) {
		s=s.trim();//get rid of empty space before and backward.
        boolean number=false;
		boolean eFlag=false;
		boolean numAfterE=false;
		boolean dotFlag=false;
		for(int i =0;i < s.length();i++){
			if(s.charAt(i)<='9' && s.charAt(i)>='0'){
				number=true;
				numAfterE=true;
			}// update the flags after the number
			else if(s.charAt(i)=='e'){//eflag can only appear once, 
				if(!number || eFlag)
					return false;
				eFlag=true;
				numAfterE=false;//once e appears make the number flag false to check no number after e
			}
			else if (s.charAt(i)=='.'){//dot flag can only appear once, once eflag appears, dot cannot
				if(eFlag || dotFlag)
					return false;
				dotFlag=true;
				// numAfterE=false;
			}
			else if(s.charAt(i)=='+' || s.charAt(i)=='-'){//+ - can only appear after e flag or at the begining.
				if(i!=0 && s.charAt(i-1)!='e')
					return false;
			}
			else return false;			
		}
		return number && numAfterE;//check number.
    }
	public static void main(String args[]){
		ValidNumber vn= new ValidNumber();
		System.out.println(vn.isNumber("1.2"));
	}
}