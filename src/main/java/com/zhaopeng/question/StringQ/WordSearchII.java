package com.zhaopeng.question.StringQ;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/word-search-ii/
 * https://www.youtube.com/watch?v=RbbkK1yLDrg
 * Created by zhaopeng on 2018/1/16.
 */
public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTire(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                helper(i, j, board, root, res);
            }
        }
        return res;
    }

    public void helper(int i, int j, char[][] board, TrieNode node, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return;
        }
        char c = board[i][j];
        if (c == '#' || node.next[c - 'a'] == null) {
            return;
        }
        node = node.next[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            //已经找到了，防止再次找
            node.word=null;
        }
        board[i][j] = '#';
        helper(i + 1, j, board, node, res);
        helper(i - 1, j, board, node, res);
        helper(i, j + 1, board, node, res);
        helper(i, j - 1, board, node, res);
        board[i][j] = c;
    }

    public TrieNode buildTire(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
}


class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}
