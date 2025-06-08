class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> temp = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            temp.add(String.valueOf(i));
        }
        Collections.sort(temp);
        List<Integer> res = new ArrayList<>();
        for(String s:temp){
            res.add(Integer.parseInt(s));
        }
        return res;
    }
}