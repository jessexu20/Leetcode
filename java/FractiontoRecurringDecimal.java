public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        String temp = "";
		HashMap <Long,Integer> map = new HashMap();
		long nu = (long) numerator;//handle extreme case Integer.MIN_VALUE and -1 
		long den = (long) denominator;
		boolean sign = nu*den >= 0 ? true:false; //handle negative 
		nu = Math.abs(nu);
		den = Math.abs(den);
		temp += String.valueOf(nu/den);
		long n = nu%den;
		if(n!=0) temp+=".";//decimal
		while(n!=0){
			if(map.containsKey(n)){//start of repeating.
				int index = map.get(n);
				temp = temp.substring(0,index)+"("+temp.substring(index)+")";
				if(!sign) temp = "-" + temp;
				return temp;
			}
			else map.put(n,temp.length());
			temp += (10*n)/den;
			n = (10*n) % den;
		}
		if(!sign) temp = "-" + temp;
		return temp;      
    }
}