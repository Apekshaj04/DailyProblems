class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        int tu = 0;
        int n = boxTypes.length;
        for(int i = 0;i<n;i++ ){
            if(truckSize==0) break;
            int no = boxTypes[i][0];
            int units = boxTypes[i][1];
            System.out.println(no+" "+units );
            if(no<=truckSize){
                tu += no*units;
                truckSize-=no;
            }
            else{
                tu +=truckSize*units;
                truckSize = 0;
            }
        }
        return tu;
    }
}