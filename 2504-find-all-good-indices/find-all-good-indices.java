class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] desc = new int[n];
        int[] asc = new int[n];
        Arrays.fill(desc,0);
        Arrays.fill(asc,0);
        desc[0]=1;
        asc[0] =1;
        for(int i =1;i<n;i++ ){
            if(nums[i]>=nums[i-1]){
                asc[i] = asc[i-1]+1;
            }
                else{
                    asc[i] = 1;
                }
            }
        
        for(int i = 1;i<n;i++){
            if(nums[i]<=nums[i-1]){
                desc[i] = desc[i-1]+1;
            }
            else{
                desc[i] = 1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i =k;i<n-k;i++){
            // System.out.println(i+" "+desc[i-1]+" "+asc[i+k]);
            if(desc[i-1]>=k && asc[i+k]>=k){
                result.add(i);
            }
        }
        return result;
    }
}
