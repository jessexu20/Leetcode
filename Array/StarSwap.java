public class StarSwap{
	public void swap(int [] arr){
		int flag = -1;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == -1){
				flag = i;
				break;
			}
		}
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == i || arr[i] == -1)
				continue;
			arr[flag] = arr[arr[i]];
			arr[arr[i]] = arr[i];
			arr[i] = -1;
			flag = i;
		}
	}
	public static void main(String args[]){
		StarSwap ss = new StarSwap();
		int [] arr = {3,1,0,2,-1,4};
		ss.swap(arr);
		for(int i: arr){
			System.out.print(i + "\t");
		}
	}
}