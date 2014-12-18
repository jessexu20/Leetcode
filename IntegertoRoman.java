import java.util.HashMap;
public class IntegertoRoman{
	public String intToRoman(int num){
		String[]lookupten={"","I","II","III","IV","V","VI","VII","VIII","IX"};
		String[]lookuphund={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String[]lookupthou={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String str="";
		int thousand=num/1000;
		num=num-thousand*1000;
		while(thousand>0){
			str=str+"M";
			thousand--;
		}
		str+=lookupthou[num/100];
		num=num % 100;
		str+=lookuphund[num/10];
		num=num % 10;
		str+=lookupten[num];
		return str;
	}
	public static void main(String args[]){
		IntegertoRoman intRo=new IntegertoRoman();
		System.out.println(intRo.intToRoman(59));
	}
}