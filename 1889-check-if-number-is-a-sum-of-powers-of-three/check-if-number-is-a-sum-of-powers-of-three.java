class Solution {

  private boolean helper(int n, int index, int sum) {
    if (sum == n) {
        return true;
    }
    if (sum > n || Math.pow(3,index)>n) {
        return false;
    }
    
    int temp = (int) Math.pow(3, index);
    
    if (helper(n, index + 1, sum + temp)) {
        return true;
    }
    
    if (helper(n, index + 1, sum)) {
        return true;
    }
    
    return false;
}

    public boolean checkPowersOfThree(int n) {
         
          return helper(n,0,0);
    }
}