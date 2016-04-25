public class AddDigits {
	public int addDigits(int num){
		if(num>=10)
			return addDigits(num/10+num%10);
		else return num;
	}

	public static void main(String args[]){
		AddDigits ad= new AddDigits();
		System.out.println(ad.addDigits(39));
	}
}