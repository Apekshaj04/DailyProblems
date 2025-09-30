class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        List<Integer> arr = new ArrayList<>();

        for(int i = 0;i<n-1;i+=1){
            arr.add((nums[i]+nums[i+1])%10);
        }
        while(arr.size()>1){
            int m = arr.size();
            if(m==1) break;
            List<Integer> newNums = new ArrayList<>();
            for(int i = 0;i<m-1;i+=1){
                int sum = (arr.get(i)+arr.get(i+1))%10;
                newNums.add(sum);
            }
            arr = newNums;
        }
        return arr.get(0);

    }
}