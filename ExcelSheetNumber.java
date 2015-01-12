public class ExcelSheetNumber{
    public int titleToNumber(String s) {
        int len=s.length();
		int sum=0;
		for(int i=len-1;i>=0;i--){
			int number=s.charAt(i)-'A'+1;
			double power=Math.pow(26,len-1-i);
			sum+=number*power;
			// System.out.println(sum);
		}
		return sum;
    }
	
	public static void main(String args[]){
		ExcelSheetNumber esn=new ExcelSheetNumber();
		System.out.println(esn.titleToNumber("AZ"));
	}
}