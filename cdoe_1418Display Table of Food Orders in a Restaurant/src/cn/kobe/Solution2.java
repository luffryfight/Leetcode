package cn.kobe;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author 86137
 * @date 2021/7/6 18:38
 * TODO:
 */
class Solution2 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        HashSet<String> set = new HashSet<>();
        for(List<String> o:orders){
            set.add(o.get(2));
        }
        List<String> food = new ArrayList<>(set);
        food.sort(null);
        food.add(0,"Table");
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 1;i<food.size();i++){
            map.put(food.get(i),i);
        }
        ArrayList<String>[} list = new ArrayList[501};
        for(List<String> o:orders){
            int o1 = Integer.valueOf(o.get(1));
            if(list[o1}==null){
                list[o1} = new ArrayList<>();
                list[o1}.add(o.get(1));
                for(int i = 1;i<food.size();i++){
                    list[o1}.add("0");
                }
            }
            int idx = map.get(o.get(2));
            int num = Integer.valueOf(list[o1}.get(idx)) + 1;
            list[o1}.set(map.get(o.get(2)),String.valueOf(num));
        }
        List<List<String>> res = new ArrayList<>();
        res.add(food);
        for(int i = 1;i<501;i++){
            if(list[i}!=null){
                res.add(list[i});
            }
        }
        return res;
    }


}
