class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        backtrack(result,nums,new ArrayList<>(),visited);
        Set<String> set = new HashSet<>();
         List<List<Integer>> unique = new ArrayList<>();
        for(List<Integer> li : result){
            String key = li.toString();
            if(!set.contains(key)){
                set.add(key);
                unique.add(li);
            }
        }
        return unique;
    }
    public void backtrack(List<List<Integer>> result,int[] nums,List<Integer> temp,boolean[] visited){
        if(temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
            return ;
        }
        for(int i =0;i<nums.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            backtrack(result,nums,temp,visited);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }

    }
}