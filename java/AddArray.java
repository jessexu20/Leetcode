public class AddArray{
	public char[] add(char [] arr, int number){
		int l = 0, n = number;
		while(n>0){
			l++;
			n/=10;
		}
		char [] result = new char [1+Math.max(l,arr.length)];
		int cur = arr.length-1;
		int carry = 0;
		int start = 0;
		while(cur>=0){
			int digit = number % 10;
			int arrDigit = arr[cur--]-'0';
			result[start++] = (char)('0' + (digit + arrDigit + carry)%10) ;
			carry = (digit + arrDigit + carry)/10;
			number /=10;
		}
		while(number > 0){
			result[start++] = (char) ('0' + number % 10);
			number /=10;
		}
		for(int i = 0; i < result.length/2;i++){
			swap(result,i,result.length-1-i);
		}
		return result;
	}
	private void swap(char [] arr, int x,int y){
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	public static void main(String args[]){
		char [] num = {'1','2','3'};
		AddArray a = new AddArray();
		char [] result = a.add(num,0);
		for(int i =0 ;i < result.length;i++){
			System.out.print(result[i]);
		}
	}
}