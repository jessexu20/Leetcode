public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int length1=num1.length();
		int length2=num2.length();
		int [] result=new int [length1+length2];
		for(int i=length1-1;i>=0;i--){
			int val1=num1.charAt(i)-'0';
			int k= length2+i;
			for(int j=length2-1;j>=0;j--){
				int val2=num2.charAt(j)-'0';
				int res=result[k]+val1*val2;
				result[k]=res%10;
				result[k-1]=result[k-1]+res/10;
				k--;
			}
		}
		String str="";
		boolean flag=true;
		for(int i =0;i<result.length;i++){
			if(result[i]==0 && flag==true)
				continue;
			else flag=false;
			str=str+Integer.toString(result[i]);
		}
		if (str=="")
			return "0";
		return str;
		
    }
	public static void main(String args[]){
		MultiplyStrings ms =new MultiplyStrings();
		String num1="9999999";
		String num2="999";
		System.out.println(ms.multiply(num1,num2));
	}
}