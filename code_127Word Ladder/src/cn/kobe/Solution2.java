package cn.kobe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 *
 * 学习学习
 * */
public class Solution2 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = queue.poll();
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet))
                    return step + 1;
            }
            step++;
        }
        return 0;
    }

    private boolean changeWordEveryOneLetter(String currentWord, String endWord,
                                             Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char ch = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (ch == k) continue;
                charArray[i] = k;
                String newWord = String.valueOf(charArray);
                if (wordSet.contains(newWord)) {//如果的单词表中有这个词
                    if (endWord.equals(newWord))//新的满足要求的词等于结果，就返回
                        return true;
                    if (!visited.contains(newWord)) {
                        queue.add(newWord);
                        visited.add(newWord);
                    }
                }
            }
            //记得修改了之后恢复
            charArray[i] = ch;
        }
        return false;
    }
}