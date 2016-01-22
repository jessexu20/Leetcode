public class ArrangeSeat{
	public int populate(boolean [] seats){
		int num = 0;
		int start = 0;
		while(start < seats.length && seats[start]==false)
			start++;
		num += start / 2;
		int end = start+1;
		while(end < seats.length){
			if(seats[end]==false)
				end++;
			else{
				num += Math.max(0,(end-start-2)/2);
				start = end;
				end++;
			}
		}
		num += Math.max(0,(end-start-2)/2);
		return num;
	}
	public static void main(String args[]){
		ArrangeSeat as = new ArrangeSeat();
		boolean [] seats = new boolean [15];
		seats[2] = true;
		seats[3] = true;
		System.out.println(as.populate(seats));
	}
}