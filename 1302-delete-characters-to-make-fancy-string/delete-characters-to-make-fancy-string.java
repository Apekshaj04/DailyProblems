class Solution {
    public String makeFancyString(String s) {
        if(s.length()==0) return s;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        int cnt = 0;
        sb.append(prev);
        for(int i =1;i<n;i++){
            if(s.charAt(i)==prev){
                cnt++;
            }
            else{
                cnt = 0;
            }
            if(cnt>=2){             
                continue;
            }
            prev = s.charAt(i);
            sb.append(prev);
        }
        return sb.toString();

        
    }
}