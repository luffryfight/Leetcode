package cn.kobe;

import java.util.*;

/**
 * @author 86137
 * @date 2021/7/3 22:34
 * TODO: 写得跟屎一样。。。下次还不如直接写暴力，然后再优化。。
 * ？？？居然还是超过79%。。。
 */
class Solution {
    public String frequencySort(String s) {
        if (s.length()<2) return s;
        //统计每个字符的个数
        int[] nums=new int[256];
        for (char ch : s.toCharArray()) {
            nums[ch]++;
        }
        //做出对应关系
        Map<Integer, List<Character>> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Character> list = map.get(nums[i]);
            if (list == null) {
                list=new ArrayList<>();
            }
            list.add((char)i);
            map.put(nums[i], list);
        }
        StringBuilder sb=new StringBuilder();
        //排序出现个数
        Arrays.sort(nums);
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int index=nums.length - i - 1;
            if (!set.contains(nums[index])) {
                if (nums[index] != 0) {
                    List<Character> list = map.get(nums[index]);
                    for (int t = 0; t < list.size(); t++) {
                        for (int j = 0; j < nums[index]; j++) {
                            sb.append(list.get(t));
                        }
                    }
                }
                set.add(nums[index]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.frequencySort("cccaaa"));
    }
}
