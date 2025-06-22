class Solution {
    public int helper(ArrayList<Integer> nums){
        int swaps = 0;
        for(int i = 0;i<nums.size();i++){
            swaps+=Math.abs(nums.get(i)-2*i);
        }
        return swaps;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(nums[i]%2==0){
                even.add(i);
            }
            else{
                odd.add(i);
            }
        }
        if(Math.abs(even.size()-odd.size())>1) return -1;
        int min = Integer.MAX_VALUE;
        if(even.size()>=odd.size()){
            min = Math.min(min,helper(even));
        }
        
        if(even.size()<=odd.size()){
            min = Math.min(min,helper(odd));
        }
        return min;
    }
        
}