class Solution {
    public int removeDuplicates(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        int i = 0;
        int j = 0;
        int prev = -1;
        while(i<n){
            prev = arr[i];
            cnt =1;
            while(i<n-1 && arr[i]==arr[i+1]){
                cnt++;
                prev = arr[i];
                i++;
            }

            if(cnt>=2){
                arr[j++] = prev;
                arr[j++] = prev;
            }
            if(cnt<2){
                arr[j++] = prev;
            }
            i++;
        }
        return j;
    }
}