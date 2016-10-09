public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean [][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i = 1; i < dp.length; i++){
            dp[i][0] = false;
        }
        for(int i = 1; i < dp[0].length; i++){
            dp[0][i] = dp[0][i-1] && p.charAt(i-1) == '*';
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else 
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)== '?');
            }
        }
        return dp[s.length()][p.length()];
    }
	public static void main(String args[]){
		WildcardMatching wm=new WildcardMatching();
		String s = "c";
		String p ="*?*";
		System.out.println(wm.isMatch(s,p));
	}
}