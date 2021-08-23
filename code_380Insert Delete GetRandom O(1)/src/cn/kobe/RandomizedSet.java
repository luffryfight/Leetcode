package cn.kobe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 作用：删除函数哪里修改一下，然后对应的random 修改下 会有优化
 * 2020/10/31
 */
public class RandomizedSet {
    List<Integer> list = new ArrayList<>();//集合内部自动处理扩容问题
    HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        //需要一个结构来表示某个数字是否存在
        if (!map.containsKey(val))//不存在就返回false
            return false;
        list.set(map.remove(val), Integer.MAX_VALUE);//不能赋值为-1，因为可能会插入-1

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random r = new Random();
        int i = r.nextInt(list.size());
        while (list.get(i) == Integer.MAX_VALUE) {
            i = r.nextInt(list.size());
        }
        return list.get(i);
    }
}
