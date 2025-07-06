class Solution {
public boolean isValid(String s) {
    for (char c : s.toCharArray()) {
        if (c != '_' && !Character.isLetter(c) && !Character.isDigit(c)) {
            return false;
        }
    }
    return true;
}

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Set<String> set = new HashSet<>();
        set.add("electronics");
        set.add("grocery");
        set.add("pharmacy");
        set.add("restaurant");
        int n = code.length;
        ArrayList<String[]> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(code[i].length()>0 && set.contains(businessLine[i]) && isActive[i] && isValid(code[i])){
                list.add(new String[]{code[i],businessLine[i]});
            }
        }
        Collections.sort(list,(a,b)->{
                if(a[1].equals(b[1])){
                    return a[0].compareTo(b[0]);
                }
                return a[1].compareTo(b[1]);
        });
        ArrayList<String> result = new ArrayList<>();
        for(String[] s :list){
            result.add(s[0]);
        }
        return result;
        
    }
}