class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int total = 0 ;
        for(int x:nums){
            total+=x;
        }
        if(total%k!=0) return false;
        boolean[] visited = new boolean[n];
        return backtrack(nums,nums.length-1,total/k,0,k,visited);
    }
    public  boolean backtrack(int[] nums,int index,int target,int sum,int k ,boolean[] visited){
        if(k==0) return true ;
        if(sum>target) return false;
        if(sum==target){
            return backtrack(nums,nums.length-1,target,0,k-1,visited);
        }
        for(int i =index;i>=0;i--){
            if(visited[i]) continue;
            visited[i] = true;
           if(backtrack(nums,i-1,target,sum+nums[i],k,visited)){
            return true;
           }
            visited[i] = false;
        }
        return false;
    }
}