public class MaxHoliday{
	public int findMax(int [][] holiday, int [][]flight,int hour){
		int [][] dp = new int [flight.length][holiday.length];
		for(int i = 0; i < holiday.length; i++)
			dp[i][0] = holiday[i][0];
		for(int i = 1; i < holiday[0].length; i++){
			// i stand for week
			for(int j = 0 ; j < flight.length; j++){
				// j is origin office
				for(int k = 0; k < flight.length; k++){
					// k is destination office
					if(flight[j][k]<=hour){//flight time needs to be smaller than some time.
						//new office holiday equals the original holiday + new office holiday
						dp[k][i] = Math.max(dp[k][i],dp[j][i-1] + holiday[k][i]);
					}
				}
			}
		}
		for(int i = 0; i < dp.length; i++){
			for(int j = 0; j< dp[0].length; j++){
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}
		int maxHour = 0;
		for(int i = 0; i < flight.length; i++){
			maxHour = Math.max(maxHour, dp[i][holiday.length-1]);
		}
		return maxHour;
		
	}
	public static void main(String args[]){
		int [][] holiday = {//column is week,holiday[i][j] stands for in week i, office j's holiday
			{0,1,2,1,0},
			{0,0,0,0,1},
			{1,1,0,1,2},
			{2,1,1,2,1},
			{1,2,3,1,2}};
		int [][] flight ={//flight[i][j] stands for fly time from city i to city j
			{0,6,3,5,2},
			{6,0,1,3,4},
			{3,1,0,2,1},
			{5,3,2,0,2},
			{2,4,1,2,0}};
		MaxHoliday mh = new MaxHoliday();
		System.out.println(mh.findMax(holiday,flight,3));
	}
}