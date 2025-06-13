/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int right) {
        if(right==1){
            if(isBadVersion(right)){
                return 1;
            }
            else{
                return 0 ;
            }
        }
        int left = 1;
        while(left<right){
            int mid =left + (right - left) / 2;
            System.out.println(mid);
            if(isBadVersion(mid)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
}