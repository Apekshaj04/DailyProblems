class Solution {
    public int largestPerimeter(int[] nums) {
    Integer[] boxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    Arrays.sort(boxed, Collections.reverseOrder());
    nums = Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
     int n = nums.length;
     for(int i = 0;i<n-2;i++){
        int max = nums[i];
        int a = nums[i+1];
        int b = nums[i+2];
        if(a+b>max){
            return a+b+max;
        }
     }
     return 0;
    }
}