public class ReverseInteger {
    public int reverse(int x) {
        long result=0;
        boolean positive=true;
        if(x<0) positive=false;
        x=Math.abs(x);
        while(x>0){
            result=10*result+x%10;
            x/=10;
        }
        if(!positive) result*=(-1);
        if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) return 0;
        else return (int) result;
    }
}