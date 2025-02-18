class Solution {
    int find(String pattern,int i ,TreeSet<Integer> set , StringBuilder sb){
        if(i==pattern.length()){
            return Integer.parseInt(sb.toString());
        }

        int minValue = Integer.MAX_VALUE;
        for(Integer num:new ArrayList<>(set)){
            if((pattern.charAt(i)=='I' && num>sb.charAt(sb.length()-1)-'0')||(pattern.charAt(i)=='D' && num<sb.charAt(sb.length()-1)-'0')){
                    set.remove(num);
                    sb.append(num);
                    minValue = Math.min(minValue,find(pattern,i+1,set,sb));
                    set.add(num);
                    sb.deleteCharAt(sb.length()-1);
            }
        }
        return minValue;
    }
    public String smallestNumber(String pattern) {
          int n = pattern.length();
        if (n < 1) {
            return "";
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= 9; i++) {
            set.add(i);
        }

        int minValue = Integer.MAX_VALUE;
        for (Integer start : new ArrayList<>(set)) { 
            set.remove(start);
            minValue = Math.min(minValue, find(pattern, 0, set, new StringBuilder().append(start)));
            set.add(start);
        }

        return String.valueOf(minValue);
    }
}