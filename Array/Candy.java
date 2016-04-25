import java.util.*;
public class Candy {
    public int candy(int[] ratings) {
        int [] amount = new int [ratings.length];
        Arrays.fill(amount,1);
        int [] left = amount.clone();
        int [] right= amount.clone();
		for(int i =1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]) left[i]=left[i-1]+1;
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]) right[i]=right[i+1]+1;
        }		
        int sum=0;
        for(int i=0;i<amount.length;i++){
            amount[i]=Math.max(left[i],right[i]);
            sum+=amount[i];
        }
        return sum;
    }
	public static void main(String args[]){
		Candy c= new Candy();
		int [] rating={1,2,3,1,2,3,1,2,2,1,2,1,1,4};
		System.out.println(c.candy(rating));
	}
}