import java.util.HashMap;
import java.util.HashSet;
public class Solution {
    public static boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> map=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        String[] arr=str.split(" ");
        if(arr.length!=pattern.length()){
            return  false;
        }
        //遍历pattern
        for (int i = 0; i < pattern.length(); i++) {
            //不存在关键字
            if(!map.containsKey(pattern.charAt(i))){
                if(set.contains(arr[i])){
                    return  false;
                }
                map.put(pattern.charAt(i),arr[i]);
                set.add(arr[i]);
            }else{
                //对应关键之不匹配
                if(!map.get(pattern.charAt(i)).equals(arr[i])){
                    return  false;
                }
            }
        }
        return  true;
    }
}
