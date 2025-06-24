class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n  = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i= 0;i<n;i++){
            if(nums[i]==key){
                int j = i;
                while(j>=0 && Math.abs(j-i)<=k){
                    set.add(j);
                    j--;
                }
                j=i+1;
                while(j<n && Math.abs(j-i)<=k){
                    set.add(j);
                    j++;
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int h:set){
            arr.add(h);
        }
        Collections.sort(arr);
        return arr;
    }
}