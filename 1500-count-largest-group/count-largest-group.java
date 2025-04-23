class Solution {
    public int countLargestGroup(int n) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 1;i<=n;i++){
            int sum = 0; 
            int num = i;
            while(num>0){
                sum += num%10;
                num = num/10;
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        int largest = Collections.max(map.values());
        int cnt =0;
        for(int v:map.values()){
            if(v==largest){
                cnt++;
            }
        }
        return cnt;
    }
}