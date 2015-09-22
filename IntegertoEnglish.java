public class IntegertoEnglish {
	String [] dic={"","Thousand","Million","Billion"};
	String [] digit={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
	String [] teens={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Ninteen"};
	String [] tens={"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
		String res="";
		for(int i = 0;num>0;i++){
			String temp=generate(num%1000);
			if(temp!=""){
				res=temp+" "+dic[i]+" "+res;
			}
			num/=1000;
		}
		if (res=="")
			return "Zero";
		int end=0;
		for(end=res.length()-1;end>=0;end--){
			if(res.charAt(end)!=' ')
				break;
		}
		return res.substring(0,end+1);
    }
	public String generate(int num){
		String temp="";
		if(num/100>0) temp+=digit[num/100]+" "+"Hundred"+" ";
		num=num%100;
		if(num/10!=1){
			if(num/10>1)
				temp+=(tens[num/10-1]+" ");
			num%=10;
			if(num>0)
				temp+=(digit[num]+" ");
		} 
		else{
			temp+=(teens[num%10]+" ");
		}
		if(temp.length()!=0)
			return temp.substring(0,temp.length()-1);
		else return temp;
	}
	public static void main(String args[]){
		IntegertoEnglish ie= new IntegertoEnglish();
		System.out.println(ie.numberToWords(122202));
	}
}
