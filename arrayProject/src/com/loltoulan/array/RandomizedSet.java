package com.loltoulan.array;

import java.util.*;

class RandomizedSet {

    List<Integer> nums;
    Map<Integer,Integer> indices;
    Random random;

    public RandomizedSet() {
        nums=new ArrayList<>();
        indices=new HashMap<>();
        random=new Random();
    }
    
    public boolean insert(int val) {
        if(indices.containsKey(val)){
            return false;
        }
        int index=nums.size();
        nums.add(val);
        indices.put(val,index);
        return true;
    }
    
    public boolean remove(int val) {
        if(!indices.containsKey(val)){
            return false;
        }
        int index=indices.get(val);
        int lastval=nums.get(nums.size()-1);
        nums.set(index,lastval);
        indices.replace(lastval,index);
        nums.remove(nums.size()-1);
        indices.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex=random.nextInt(nums.size());
        return nums.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        // ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
//        boolean param_1 = obj.insert(val);
//        boolean param_2 = obj.remove(val);
//        int param_3 = obj.getRandom();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */