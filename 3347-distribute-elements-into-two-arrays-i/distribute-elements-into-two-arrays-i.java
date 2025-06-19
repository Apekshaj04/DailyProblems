class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        if(n<=2){
            for(int i = 0;i<n;i++){
                result[i] = nums[i];
            }
            return result;
        }
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        int max1 = nums[0];
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        int max2 = nums[1];
        for(int i=2;i<n;i++){
            if(max1>max2){
                arr1.add(nums[i]);
                max1 = nums[i];
            }
            else{
                arr2.add(nums[i]);
                max2 = nums[i];
                
            }
        }
        int k = 0;
        for(int i = 0;i<arr1.size();i++){
            result[k] = arr1.get(i);
            k++;
        }
        for(int i=0;i<arr2.size();i++){
            result[k] = arr2.get(i);
            k++;
        }
        return result;
    }
}