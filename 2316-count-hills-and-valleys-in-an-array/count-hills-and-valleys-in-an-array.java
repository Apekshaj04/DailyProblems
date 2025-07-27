class Solution {
    public int countHillValley(int[] nums) {
        int count = 0 ;
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(arr.size()!=0 && arr.get(arr.size()-1)==nums[i]){
                continue;
            }
            arr.add(nums[i]);
        }
        int size = arr.size();
        for(int i = 1;i<size-1;i++){
            if((arr.get(i)>arr.get(i-1) && arr.get(i)>arr.get(i+1)) ||(arr.get(i)<arr.get(i-1) && arr.get(i)<arr.get(i+1))){
                count++;
            }
        }
        return count;
        
        
    }
}