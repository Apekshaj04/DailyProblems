class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,0,target,result,new ArrayList<>());
        List<List<Integer>> unique = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(List<Integer> r:result){
            List<Integer> sorted = new ArrayList<>(r);
            Collections.sort(sorted);
            String key = sorted.toString();
            if(!set.contains(key)){
                set.add(key);
                unique.add(sorted);
            }
        }
        
        return unique;
    }
    public void backtrack(int[] nums,int sum,int target,List<List<Integer>> result,List<Integer> temp){
        if(sum>target) return ; 
        if(sum==target){
            result.add(new ArrayList<>(temp));
            return ; 
        }
        for(int i = 0 ;i<nums.length;i++){
            sum+=nums[i];
            temp.add(nums[i]);
            backtrack(nums,sum,target,result,temp);
            sum-=nums[i];
            temp.remove(temp.size()-1);
        }
    }
}