import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] result = new int[n];
        for(int i = 0;i<n;i++){
            int index = bs(potions,spells[i],success);
            if(index!=-1) result[i] = m-index;
        }
        return result;
    }
    private int bs(int[] potions,long strength,long success){
        int low = 0;
        int high = potions.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if((long) potions[mid]*strength>=success){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
