class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
            for(int i = 0;i<n-1;i++){
                if(nums[i]==nums[i+1]){
                    nums[i] = nums[i]*2;
                    nums[i+1] = 0;
                }
            }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ;i<n;i++){
            if(nums[i]!=0){
                arr.add(nums[i]);
            }
        }
        for(int i = 0 ;i<arr.size();i++){
            nums[i]  = arr.get(i);
        }
        for(int i = arr.size();i<n;i++){
            nums[i] = 0;
        }
        return nums;


    }
}