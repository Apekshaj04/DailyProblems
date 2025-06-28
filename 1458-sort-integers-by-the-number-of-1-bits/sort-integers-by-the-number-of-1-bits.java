class Solution {
    public int findOne(int num){
        int count=0;
        while(num>0){
            count+=(num&1);
            num = num>>1;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed,(a,b)->{
            int countA = findOne(a);
            int countB = findOne(b);
            if(countA==countB){
                return a-b;
            }
            return countA-countB;
        });
        for(int i = 0;i<arr.length;i++){
            arr[i] = boxed[i];
        }
        return arr;
    }
}