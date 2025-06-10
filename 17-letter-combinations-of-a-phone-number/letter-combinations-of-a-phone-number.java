class Solution {
    public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    int n  = digits.length();
    if(n==0) return result;

       HashMap<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r','s'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y','z'));

        function(digits,map,result,0,new StringBuilder());
        return result;     

    }
    public void function(String digits,HashMap<Integer,List<Character>> map, List<String> result,int index,StringBuilder sb){
        if(index==digits.length()){
            result.add(sb.toString());
            return ; 
        }
            int num = digits.charAt(index) - '0';
            List<Character> list = map.get(num);
            for(int j = 0;j<list.size();j++){
                sb.append(list.get(j));
                function(digits,map,result,index+1,sb);
                sb.deleteCharAt(index);
            }
        


    }
}