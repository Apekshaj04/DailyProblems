class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int n= s.length();
        int value=0;
        for(int i = n-1;i>=0;i--){
            char c = s.charAt(i);
            if(c=='V' || c=='X'){
                if(i>0 && s.charAt(i-1)=='I'){
                    if(c=='V') value+=4;
                    if(c=='X') value+=9;
                    i--;
                    continue;
                }
            }
            else if(c=='D' || c=='M'){
                if(i>0 && s.charAt(i-1)=='C'){
                    if(c=='D') value+=400;
                    if(c=='M') value+=900;
                        i--;
                        continue;
                    
                }
            }
            else if(c=='L' || c=='C'){
                if(i>0 && s.charAt(i-1)=='X'){
                    if(c=='L') value+=40;
                    if(c=='C') value+=90;
                    i--;
                    continue;
                }
            }
            
            value+=map.get(c);
        }
        return value;
    }
}