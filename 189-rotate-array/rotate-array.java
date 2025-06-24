class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int temp= n-k;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = temp;i<n;i++){
            res.add(nums[i]);
        }
        for(int i = 0;i<=temp-1;i++){
            res.add(nums[i]);
        }
        for(int i = 0;i<n;i++){
            nums[i] = res.get(i);
        }
    }
}