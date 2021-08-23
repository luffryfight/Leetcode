package cn.kobe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution2 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new LinkedList<>();
        TrieNode root = new TrieNode();
        TrieNode reverseRoot = new TrieNode();

        String word;
        TrieNode node, reverseNode, child;
        for (int i = 0; i < words.length; i++) {
            word = words[i];
            if (word.isEmpty()) {
                for (int j = 0; j < words.length; j++) {
                    if (j != i && isPalindrome(words[j], 0, words[j].length() - 1)) {
                        ans.add(Arrays.asList(j, i));
                        ans.add(Arrays.asList(i, j));
                    }
                }
                continue;
            }

            node = root;
            reverseNode = reverseRoot;

            int chIndex;
            for (int j = 0, k = word.length() - 1; k >= 0; j++, k--) {
                chIndex = word.charAt(j) - 'a';
                child = node.children[chIndex];
                if (child == null) {
                    child = node.children[chIndex] = new TrieNode();
                }
                node = child;

                chIndex = word.charAt(k) - 'a';
                child = reverseNode.children[chIndex];
                if (child == null) {
                    child = reverseNode.children[chIndex] = new TrieNode();
                }
                reverseNode = child;
            }
            node.wordIndex = i;
            reverseNode.wordIndex = i;
        }

        for (int i = 0; i < words.length; i++) {
            word = words[i];
            if (word.isEmpty()) {
                continue;
            }

            int lastWordIndex = word.length() - 1;

            // 长串在前，长串正序跟反向前缀树匹配
            reverseNode = reverseRoot;
            for (int j = 0; j <= lastWordIndex; j++) {
                child = reverseNode.children[word.charAt(j) - 'a'];
                if (child == null) {
                    break;
                }
                if (child.wordIndex != -1 && child.wordIndex != i && isPalindrome(word, j + 1, lastWordIndex)) {
                    ans.add(Arrays.asList(i, child.wordIndex));
                }
                reverseNode = child;
            }

            // 长串在后，长传反序跟正向前缀树匹配
            node = root;
            // 这里排除了j为0的情况，因为j等于0时，会得到和上面的j等于 wordLength-1 一样的结果
            for (int j = lastWordIndex; j > 0; j--) {
                child = node.children[word.charAt(j) - 'a'];
                if (child == null) {
                    break;
                }
                if (child.wordIndex != -1 && child.wordIndex != i && isPalindrome(word, 0, j - 1)) {
                    ans.add(Arrays.asList(child.wordIndex, i));
                }
                node = child;
            }
        }
        return ans;
    }

    private boolean isPalindrome(String word, int start, int end) {
        while (start < end && word.charAt(start) == word.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }
}

class TrieNode {

    public int wordIndex = -1;
    public TrieNode[] children = new TrieNode[26];

}
