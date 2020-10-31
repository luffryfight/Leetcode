package cn.kobe;

import com.sun.org.apache.bcel.internal.generic.AllocationInstruction;

import java.util.*;

/**
 * 作用：
 * 2020/10/31
 */
class RandomizedCollection {
    ArrayList<Integer> list=new ArrayList<>();//集合内部自动处理扩容问题
    HashMap<Integer,ArrayList<String>> map=new HashMap<>();
    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag=true;
        if (map.containsKey(val)){
            flag= false;
        }
        ArrayList array = flag==true?new ArrayList():map.get(val);
        array.add(list.size()+"");
        list.add(val);
        map.put(val,array);
        return flag;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)){
            List<String> array=map.get(val);
            int lastIndex=list.size()-1;
            int lastValue=list.get(lastIndex);
            //删除最后一个索引，反正没要求
            int index=Integer.parseInt(array.remove(array.size()-1));

            if (array.size()==0)//没有该数字就删除标记
                map.remove(val);
            //删除
            ArrayList arrayLast=map.get(lastValue);
            arrayLast.add(index+"");
            arrayLast.remove(lastIndex+"");//删除最后那个元素的索引，设置为val的索引
            if (lastIndex!=list.size()-1)
             map.put(lastValue,arrayLast);
            list.set(index,lastValue);
            list.remove(lastIndex);
            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random r=new Random();
        return list.get(r.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection s=new RandomizedCollection();
        s.insert(1);
        s.remove(1);
        s.insert(1);



        System.out.println(s.getRandom());
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
