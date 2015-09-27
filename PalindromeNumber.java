public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x>=Integer.MAX_VALUE||x<=Integer.MIN_VALUE||x<0)
            return false;
        int cur=x;
        int count=0;
        while(x>0){
            count=10*count+(x%10);
            x/=10;
        }
        return cur==count;
    }
}