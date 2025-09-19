class Solution {
    public List<String> cellsInRange(String s) {
        int index = s.indexOf(':');
        String left = s.substring(0,index);
        System.out.println(left);
        String right = s.substring(index+1);
        char start = left.charAt(0);
        char end = right.charAt(0);
        int startC = (int)(start-'A');
        int endC = (int)(end-'A');
        int startN = Integer.valueOf(left.substring(1));
        int endN = Integer.valueOf(right.substring(1));
        System.out.println(startN+" "+endN);
        System.out.println(startC+" "+endC);
        List<String> list = new ArrayList<>();
        for(int i = startC;i<=endC;i++){
            String t = ""+(char)(i+'A');
            for(int j = startN;j<=endN;j++){    
                list.add(t+""+j);     
            }
        }
        return list;


        
    }
}
