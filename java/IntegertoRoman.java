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
    public String intToRoman(int num) {
        String [] sample= {"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
        int step=0;
        String str="";
        while(num>0){
            String temp= sample[num%10];
            switch (step){
                case 1: 
                    temp=temp.replace('X','C');
                    temp=temp.replace('V','L');
                    temp=temp.replace('I','X');
                    break;
                case 2: 
                    temp=temp.replace('X','M');
                    temp=temp.replace('V','D');
                    temp=temp.replace('I','C');
                    break;
                case 3:
                    temp=temp.replace('I','M');
                    break;
            }
            str=temp+str;
            step++;
            num/=10;
        }
        return str;
    }
	public static void main(String args[]){
		IntegertoRoman intRo=new IntegertoRoman();
		System.out.println(intRo.intToRoman(59));
	}
}