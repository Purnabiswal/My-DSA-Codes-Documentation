package src.T_20_Implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random=new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index=map.get(val);

        int t=list.getLast();
        list.set(index, t);
        list.removeLast();
        map.put(t, index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int r= random.nextInt(list.size());
        return list.get(r);
    }
}
