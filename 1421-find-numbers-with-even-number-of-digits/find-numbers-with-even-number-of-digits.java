class Solution {
    public boolean nod(int x){
        int no = 0 ;
        while(x>0){
            no++;
            x=x/10;
        }
        return no%2==0?true:false;

    }
    public int findNumbers(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(nod(nums[i])){
                cnt++;
            }
        }
        return cnt ;
    }
}