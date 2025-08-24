class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        int n = nums.length;
        if(n==0) return 0;
        int current = 1;
        Arrays.sort(nums);
        TreeSet<Integer> set = new TreeSet<>();
        for(int num:nums) set.add(num);
        ArrayList<Integer> res = new ArrayList<>(set);
        for(int i =1;i<res.size();i++){

            if(res.get(i)==(res.get(i-1)+1)){
                current++;
    
            }
            else{
                longest = Math.max(longest,current);
                current = 1;
            }
        }
        longest = Math.max(longest,current);
        return longest;
    }
}