public class MinCut {
    public int minCut(String s) {
        int[] mincut=new int [s.length()+1];
        for(int i=1;i<mincut.length;i++){
            mincut[i]=i-1;
        }
        for(int i=1;i<s.length();i++){
            int j=0;
            for(j=0;i-j>=0 && i+j<s.length() && s.charAt(i-j)==s.charAt(i+j);j++)
                mincut[i+j+1]=Math.min(mincut[i+j+1],1+mincut[i-j]);
            for(j=0;i-j>0 && i+j<s.length() && s.charAt(i-j-1)==s.charAt(i+j);j++)
                mincut[i+j+1]=Math.min(mincut[i+j+1],1+mincut[i-j-1]);
        }
        return mincut[s.length()];
    }
	public static void main(String args[]){
		MinCut mc= new MinCut();
		System.out.println(mc.minCut("a"));
	}
}