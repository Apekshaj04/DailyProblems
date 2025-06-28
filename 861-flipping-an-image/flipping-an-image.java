class Solution {                
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int m = image[0].length;
        for(int i =0;i<n;i++){
            int[] reversed = image[i];
            for(int j=0;j<m/2;j++){
                int temp = reversed[j];
                reversed[j] = reversed[m-j-1];
                reversed[m-j-1] = temp;
            }
            for(int j = 0;j<m;j++){
                reversed[j] = 1^reversed[j];
            }
            image[i] = reversed;
        }
        return image;
    }
}