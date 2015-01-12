public class MultiplyStrings{
    public String multiply(String num1, String num2) {
        StringBuffer result=new StringBuffer();
		int len1=num1.length();
		int len2=num2.length();
		if(len1*len2==0) return "0";
		int carry=0;
		
		
		
    }
	public static void main(String args[]){
		String str1="13";
		String str2="12";
		MultiplyStrings ms= new MultiplyStrings();
		System.out.println(ms.multiply(str1,str2));
	}
	
	
	
}