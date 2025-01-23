class Solution {
    public boolean isSafe(int[][] image,int i,int j,int pc,int color){
        int n = image.length;
        int m = image[0].length;
        if(i<0 || i>=n || j<0 || j>=m || image[i][j]!=pc || image[i][j]==color){
            return false;
        }
        return true;
    }
    public void recursive(int[][] image,int i ,int j,int color,int pc){
        if(!isSafe(image,i,j,pc,color)){
            return ;
        }
  
        image[i][j] = color;
       recursive(image,i+1,j,color,pc);
       recursive(image,i,j+1,color,pc);
        recursive(image,i-1,j,color,pc);
         recursive(image,i,j-1,color,pc);
       
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prevColor = image[sr][sc];
        if(prevColor!=color){
             recursive(image,sr,sc,color,prevColor);
        }
        return image;
    }
}