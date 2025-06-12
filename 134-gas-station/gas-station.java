class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int curr_tank = 0;
        int total = 0;
        int n = gas.length;
        for(int i =0;i<n;i++){
            curr_tank += gas[i] - cost[i]  ;
            total += gas[i]-cost[i];
            if(curr_tank<0){
                start  = i+1;
                curr_tank = 0;
            }
        }
        return total>=0?start:-1 ;
    }
}