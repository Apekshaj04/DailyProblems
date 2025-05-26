class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        int n = nums.length;
        int total = 1<<n;
        for(int masks = 0;masks<total;masks++){
            ArrayList<Integer> x = new ArrayList<>();
            for(int j = 0;j<n;j++){
                if((masks & (1<<j))!=0){
                    x.add(nums[j]);
                }
            }
            arr.add(x);
        }
        return arr;
    }
}