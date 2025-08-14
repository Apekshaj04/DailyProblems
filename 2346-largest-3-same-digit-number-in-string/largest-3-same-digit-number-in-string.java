class Solution {
    public String largestGoodInteger(String s) {
        int n = s.length();
        int key = -1;
        for(int i = 0;i<n;i++){
            int size = 1;
            int present = (int)(s.charAt(i)-'0');
            int j= i+1;
            while(j<n && s.charAt(j)==s.charAt(i)){
                j++;
                size++;
                System.out.println(present);
            }
            if(size>=3){
                key = Math.max(key,present);
            }
            i = j-1;
        }
        if(key==-1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append(key);
        sb.append(key);
        return sb.toString();
    }
}