public class SwapVowel {
    public String reverseVowels(String s) {
        char [] charArray = s.toCharArray();
        int i = 0, j = charArray.length-1;
        while(i<j){
            while(!isVowel(charArray[i]))
                i++;
            while(!isVowel(charArray[j]))
                j--;
			if
            swap(charArray,i++,j--);
        }
		
        return new String(charArray);
    }
    private void swap(char [] arr, int i, int j){
        char t = arr[i];
        arr[i]= arr[j];
        arr[j] = t;
    }
    private boolean isVowel(char c){
        char [] vowels = {'a','e','i','o','u'};
        for(char v: vowels){
            if(c==v)
                return true;
        }
        return false;
    }
	public static void main(String args[]){
		SwapVowel sv = new SwapVowel();
		System.out.println(sv.reverseVowels("hello"));
	}
}