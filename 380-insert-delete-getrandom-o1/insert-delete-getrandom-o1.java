import java.util.*;
class RandomizedSet {
    List<Integer> list ;
    Random rand;
    Map<Integer,Integer> map;
    public RandomizedSet() {
        list = new ArrayList<>();
        rand = new Random();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int lastVal = list.get(list.size()-1);
        int index = map.get(val);
        list.set(index,lastVal);
        map.put(lastVal,index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;

    }
    
    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */