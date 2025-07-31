class Solution {
    public int subarrayBitwiseORs(int[] nums) {
        HashSet<Integer> ans = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        for(int x:nums){
            Set<Integer> curr2 = new HashSet<>();
            for(int y:curr){
                curr2.add(y|x);
            }
            curr2.add(x);
            curr = curr2;
            ans.addAll(curr);
        }
        return ans.size();
        
    }
}