class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
         backtrack(result,nums,new ArrayList<>(),visited);
         return result;
    }
    public void backtrack(List<List<Integer>> result,int[] nums,List<Integer> arr,boolean[] visited){
        if(arr.size()==nums.length){
            result.add(new ArrayList<>(arr));
            return ;
        }
        for(int i = 0;i<nums.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr.add(nums[i]);
            backtrack(result,nums,arr,visited);
            arr.remove(arr.size()-1);
            visited[i] = false;
        }
    }
}