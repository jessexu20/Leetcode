public class ReverseStringII {
    public void reverseWords(char[] s) {
        for(int i = 0; i < s.length/2; i++){
            swap(s,i,s.length-i-1);
        }
        int i = 0,j = 0;
        while(i < s.length && j < s.length){
            if(s[j]==' '){
                for(int k = 0;k<(j-i)/2;k++){
                    swap(s,i+k,j-1-k);
                }
                i=j+1;
            }
            j++;
        }
		// String t = new String(s);
		// System.out.println(i+"\t"+j+"\t"+t);
        if(i<s.length && j>=s.length){
            for(int k = 0;k<(j-i)/2;k++){
            	swap(s,i+k,j-1-k);
			}
        }
    }
    public void swap(char [] arr, int x, int y){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
	public static void main(String args[]){
		ReverseStringII rs = new ReverseStringII();
		String str = "a";
		char [] charArr = str.toCharArray();
		rs.reverseWords(charArr);
		System.out.println(new String(charArr));
	}
}