public class RealNum{//5.2
	public String real(double x){
		if(x>=1 || x<=0)
			return "error";
		String str="0.";
		double div=0.5;
		while(x>0){
			if(str.length()>32)
				return "Error";
			if(x>=div){
				x-=div;
				str+=1;
			}
			else str+=0;
			div/=2;
		}
		return str;
	}
	public static void main(String args[]){
		RealNum rn= new RealNum();
		System.out.println(rn.real(0.875));
	}
	
}