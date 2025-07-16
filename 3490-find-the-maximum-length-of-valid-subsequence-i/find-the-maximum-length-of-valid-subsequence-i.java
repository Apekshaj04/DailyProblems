class Solution {
    public int maximumLength(int[] nums) {
        int odd = 0,even = 0;
        int countO = 0 ,countE = 0;
        for(int num:nums){
            if(num%2==0){
                even++;
            }
            else{
                odd++;
            }
        }
        for(int num:nums){
            if(num%2==0){
                countE = Math.max(countE,countO+1);
            }
            else{
                countO = Math.max(countO,countE+1);
            }
        }
        return Math.max(Math.max(even,odd),Math.max(countO,countE));

    }
}