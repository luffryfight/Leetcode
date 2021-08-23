package cn.kobe;

import sun.nio.cs.US_ASCII;

import java.net.SocketImpl;
import java.util.*;

/**
 * @author 86137
 * @date 2021/7/6 17:25
 * TODO: 太慢了。。。而且感觉写了很久。
 * 因为tableid是小于500 可以直接数组保存
 */
public class Solution {

    public List<List<String>> displayTable(List<List<String>> orders) {

        //列表
        LinkedList<String> table =new LinkedList<>();

        HashMap<String,ArrayList<String>> users=new LinkedHashMap<>();
        //保存客户的id
        LinkedList<String> tableNumber =new LinkedList<>();
        orders.stream().forEach(list ->{
            String index = list.get(1);
            String food = list.get(2);
            ArrayList<String> arrayList = new ArrayList<>();
            if (users.containsKey(index)) {//没有出现过
                arrayList=users.get(index);
            }
            arrayList.add(food);
            users.remove(index);
            users.put(index, arrayList);
            //列表添加
            if (!table.contains(food))
                table.add(food);
            //添加客户
            if (!tableNumber.contains(index))
                tableNumber.add(index);
        });
        //排序
        Collections.sort(table);
        tableNumber.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1)-Integer.parseInt(o2);
            }
        });
        //每个菜单对应的索引
        Map<String,Integer> foodIndex=new HashMap<>();
        for (int i = 0; i < table.size(); i++) {
            foodIndex.put(table.get(i),i+1);
        }
        table.addFirst("Table");
        //封装结果
        List<List<String>> res=new LinkedList<>();
        res.add(table);
        for (int i = 0; i < tableNumber.size(); i++) {
            List<String> resOne=new ArrayList<>();
            String index = tableNumber.get(i);
            resOne.add(index);
            ArrayList<String> hasFood = users.get(index);
            for (int j = 1; j < table.size(); j++) {
                resOne.add("0");
            }
            for (int j = 0; j < hasFood.size(); j++) {
                String hashFoodName = hasFood.get(j);
                Integer integer = foodIndex.get(hashFoodName);
                String foodNum = resOne.get(integer);
                //数量加1
                resOne.set(integer,String.valueOf(Integer.parseInt(foodNum)+1));
            }
            res.add(resOne);
        }
        return res;
    }

    public static void main(String[} args) {
        Solution solution=new Solution();
        String[}[} res= {{"David","3","Ceviche"},{"Corina","10","Beef Burrito"},{"David","3","Fried Chicken"},{"Carla","5","Water"},{"Carla","5","Ceviche"},{"Rous","3","Ceviche"}};
        List<List<String>> add=new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            add.add(Arrays.asList(res[i}));
        }
        solution.displayTable(add);
    }
}
