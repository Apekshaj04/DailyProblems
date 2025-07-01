class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n3 = nums3.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                set.add(nums1[i]);
                i++;
                j++;
            }
        }

        i = 0;
        j = 0;
        while(i<n2 && j<n3){
            if(nums2[i]<nums3[j]){
                i++;
            }
            else if(nums2[i]>nums3[j]){
                j++;
            }
            else{
                set.add(nums2[i]);
                i++;
                j++;
            }
        }
        i = 0 ;
        j = 0;
        while(i<n1 && j<n3){
            if(nums1[i]<nums3[j]){
                i++;
            }
            else if(nums1[i]>nums3[j]){
                j++;
            }
            else{
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        for(int d:set){
            res.add(d);
        }
        return res;
    }
}