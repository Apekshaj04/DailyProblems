class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int[] mat:matrix){
            if(binsearch(mat,m,target)) return true;
        }
        return false;
    }
    public boolean binsearch(int[] mat,int n ,int target){
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(mat[mid]==target) return true;
            if(mat[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}