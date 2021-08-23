package cn.kobe;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    //暴力法:超出时间
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                List<Integer> list = new LinkedList<>();
                if (i != j && isPalindrome(words[i] + words[j])) {
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) sb.append(c);
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        String[] s = {"abcd", "dcba", "lls", "s", "sssll"};
        so.palindromePairs(s);
        System.out.println();
    }
}
