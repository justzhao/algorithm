package com.zhaopeng.question.Normal;

/**
 * Created by zhaopeng on 2017/5/18.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {

                if (find(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] b, String word, int index, int i, int j, boolean[][] visited) {

        if (index == word.length()) return true;

        if (i < 0 || j < 0) return false;
        if (i >= b.length) return false;

        if (j >= b[i].length) return false;
        if (visited[i][j]) return false;
        char c = word.charAt(index);
        if (c != b[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (find(b, word, index + 1, i + 1, j, visited) || find(b, word, index + 1, i, j + 1, visited) || find(b, word, index + 1, i - 1, j, visited) || find(b, word, index + 1, i, j - 1, visited)) {
            return true;
        }

        visited[i][j] = false;

        return false;


    }

    public static void main(String args[]) {
        WordSearch w = new WordSearch();
        char a[][] = new char[2][2];
        a[0][0] = 'a';
        a[0][1] = 'b';
        a[1][0] = 'c';
        a[1][1] = 'd';
        w.exist(a, "abcd");

    }
}
