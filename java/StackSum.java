import java.util.*;
public class StackSum{
	public int getSum(Stack<Integer> s1,Stack<Integer> s2,int n){
		if(s2.size()<s1.size())
			//ensure that s1 is shorter than s2;
			return getSum(s2,s1,n);
		int sum = 0;
		int length1 = s1.size();
		int length2 = s2.size();
		if(s1.size()<1){
			while(n>0){
				if(!s2.isEmpty())
					sum+=s2.pop();
				n--;
			}
			return sum;
		}
		int row = Math.min(n,length1);
		int col = Math.min(n,length2);
		int [][] dp = new int [row+1][col+1];
		//dp Init
		dp[0][0]=0;
		int temp = 0;
		for(int i = 1; i<=row;i++){
			temp = temp + s1.pop();
			dp[i][0] = temp;
		}
		temp = 0;
		for(int i = 1; i<=col;i++){
			temp = temp + s2.pop();
			dp[0][i] = temp;
		}
		//Add sum
		for(int i = 1; i <=row;i++){
			for(int j = 1; j <=Math.min(col-i,col);j++){
				dp[i][j] = dp[i][j-1] + dp[i-1][j]; 
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <=n;i++){
			max = Math.max(max,dp[i][n-i]);
		}
		return max;
	}
	public static void main(String args[]){
		StackSum ss = new StackSum();
		Stack<Integer> s1 = new Stack();
		Stack<Integer> s2 = new Stack();
		s1.push(3);s1.push(700);s1.push(4);s1.push(1);
		s2.push(6);s2.push(10);s2.push(5);
		System.out.println(ss.getSum(s1,s2,2));
	}
}