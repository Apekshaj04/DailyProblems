class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        if(n<=8){
            return n;
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c:word.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

// 2. Sort the list with a custom comparator (descending order)
list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

// 3. Copy the sorted list back into a LinkedHashMap
Map<Character, Integer> sortedMap = new LinkedHashMap<>();
for (Map.Entry<Character, Integer> entry : list) {
    sortedMap.put(entry.getKey(), entry.getValue());
}

int count = 0;
int factor = 1;
int total = 0;
for(Map.Entry<Character,Integer> mpp: sortedMap.entrySet()){
    char key = mpp.getKey();
    int value = mpp.getValue();
    count++;

    total+= factor*value;
        if(count%8==0){
        factor++;
    }


}
return total;

    }
}