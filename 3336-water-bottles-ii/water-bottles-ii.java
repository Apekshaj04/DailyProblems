class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int full = numBottles,empty = 0,drunk = 0;
        while (full > 0 || empty >= numExchange){
            if(empty>=numExchange){
                empty -= numExchange;
                numExchange++;
                full++;
            }
            else{
                drunk+=full;
                empty+=full;
                full = 0;
            }
            // System.out.println(full+" "+empty+" "+numExchange+" "+drunk);
        }
        return drunk;
    }
}