class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean isOdd = true;
        boolean isEven = true;

        int n = nums1.length;
        // int[] nums2 = new int[n];
        for(int i = 0 ;i<n;i++){
            int flag = 0;
            if(nums1[i]%2==0){
                continue;
            }
            for(int j = 0;j<n;j++){
                if((nums1[i]-nums1[j])%2==0){
                    flag =1 ;
                    break;
                }
            }
            if(flag==0){
                isEven = false;
            }
        }

         for(int i = 0 ;i<n;i++){
            int flag = 0;
            if(nums1[i]%2!=0){
                continue;
            }
            for(int j = 0;j<n;j++){
                if((nums1[i]-nums1[j])%2!=0){
                    flag =1 ;
                    break;
                }
            }
            if(flag==0){
                isOdd = false;
            }
        }
        return isOdd | isEven;
    }
}