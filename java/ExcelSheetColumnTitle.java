public class ExcelSheetColumnTitle{
	public int build(int n,String [] table,StringBuffer res){
		int m=0;
		if(n>26){
		    if(n%26==0)
		        m=build(n/26-1,table,res);
			else m=build(n/26,table,res);
		}
		m=n-m*26;	
		res.append(table[m]);
		return n;
	}
    public String convertToTitle(int n) {
        String[] table={"","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		StringBuffer result=new StringBuffer();
		
		n=build(n,table,result);
		return result.toString();
    }
	public static void main(String args[]){
		ExcelSheetColumnTitle esct= new ExcelSheetColumnTitle();
		System.out.println(esct.convertToTitle(702));
	}
} 