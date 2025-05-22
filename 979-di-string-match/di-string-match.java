class Solution {
    public int[] diStringMatch(String s) {
        int smallest = 0 ;
        int largest = s.length();
        int n = s.length() ; 
        int[] arr = new int[n+1];
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<=n;i++){
            set.add(i);
        }
        for(int i = 0;i<n;i++){
            if(s.charAt(i)=='I'){
                arr[i] = smallest ; 
                set.remove(smallest);
                smallest++;
            }
            else{
                arr[i] = largest ;
                set.remove(largest);
                largest--;
            }
        }
        int y = set.iterator().next();
        arr[n] = y;
        return arr;

    }
}