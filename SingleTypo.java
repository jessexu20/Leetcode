public class SingleTypo{
	String [] vocabulary;
	SingleTypo(String [] v){
		vocabulary = v;
	}
	public boolean singleTypo(String str){
		for(int i = 0; i < vocabulary.length; i++){
			if(str.length()!=vocabulary[i].length()) continue;
			if(check(str,vocabulary[i]))
				return true;
		}
		return false;
	}
	public boolean check(String a, String b){
		int cnt = 0;
		for(int i = 0; i < a.length(); i++){
			if(a.charAt(i)!= b.charAt(i))
				cnt++;
			if(cnt>1)
				break;
		}
		return cnt == 1;
	}
	public static void main(String args[]){
		String [] vocab = {"apple", "pineapple", "banana", "cucumber"};
		SingleTypo st = new SingleTypo(vocab);
		System.out.println(st.singleTypo("apble"));
		System.out.println(st.singleTypo("abble"));
		System.out.println(st.singleTypo("aple"));
		System.out.println(st.singleTypo("apple"));
		
	}
}