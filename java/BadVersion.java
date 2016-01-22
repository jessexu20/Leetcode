/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class BadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        return findVersion(1,n);
    }
    public int findVersion(int start,int end){
        if (start==end)
            return start;
        int mid=start+(end-start-1)/2;
        if (isBadVersion(mid))
            return findVersion(start,mid);
        else return findVersion(mid+1,end);
    }
}