class Solution {
    public int maxDifference(String s) {
        TreeMap<Character,Integer> map = new TreeMap<>(Collections.reverseOrder());
        int oddMax=  0, oddMin = Integer.MAX_VALUE,evenMax = 0 ,evenMin = Integer.MAX_VALUE;
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> mpp:map.entrySet()){
            int val = mpp.getValue();
            // System.out.println(val);
            if(val%2==0){
                evenMax = Math.max(val,evenMax);
                evenMin = Math.min(val,evenMin);
            }
            else{
                oddMax = Math.max(val,oddMax);
                oddMin = Math.min(val,oddMin);
            }
        }
        
        return oddMax-evenMin;
 
    }
}