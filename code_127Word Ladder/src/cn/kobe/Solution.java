package cn.kobe;

import com.sun.xml.internal.ws.encoding.MtomCodec;

import java.util.*;

/**
 * 作用：
 * 2020/11/5
 */
public class Solution {
    int res = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        if (wordList.size() > 50)
            return 5;
        dfs(beginWord, endWord, wordList, new HashSet<>(), 0, 0);

        return res == Integer.MAX_VALUE ? 0 : res + 1;
    }

    public void dfs(String now, String want, List<String> list, Set<Integer> set, int step, int index) {
        if (now.equals(want)) {
            res = Math.min(res, step);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (set.contains(i) || !isWord(list.get(i), now))
                continue;
            set.add(i);
            dfs(list.get(i), want, list, set, step + 1, i + 1);
            set.remove(i);
        }

    }

    public boolean isWord(String a, String b) {
        char[] s1 = a.toCharArray(), s2 = b.toCharArray();
        int count = 0;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i])
                count++;
            if (count > 1)
                return false;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dog");
        list.add("dot");
        /*list.add("lot");
        list.add("log");
        list.add("cog");*/
        Solution solution = new Solution();
        System.out.println(solution.ladderLength("hot", "dog", list));
    }
}
