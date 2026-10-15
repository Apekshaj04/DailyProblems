class Solution {
    public int sumCounts(List<Integer> nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int n = nums.size();
        for(int i=0;i<n;i++){
            
            for(int j=i;j<n;j++ ){
                int num = nums.get(j);
                set.add(num);
                int size = set.size();
                sum+=Math.pow(size,2);
            }
            set.clear();
        }
        return sum;
        
    }
}