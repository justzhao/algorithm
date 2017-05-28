package com.zhaopeng.question.Normal;

import java.util.*;

/**
 * Created by zhaopeng on 2017/5/28.
 */
public class WordLadder {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        List<String> lists = new ArrayList<>();

        lists.add(beginWord);

        List<String> visited = new ArrayList<>();

        int count = 1;

        while (!lists.contains(endWord)) {

            List<String> next = new ArrayList<>();
            for (String s : lists) {
                char chars[] = s.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char o = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String str = new String(chars);
                        if (!visited.contains(str) && wordList.contains(str)) {
                            next.add(str);
                            visited.add(str);
                        }
                    }

                    chars[i] = o;
                }

            }
            if (next.size() == 0) {
                return 0;
            }
            count++;
            lists = next;


        }

        return count;
    }

    /*
    适合使用bfs 宽度遍历法来遍历
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            List<String> lists = new ArrayList<>();

            Queue<String> queue = new LinkedList<>();
            int count = 1; // 默认开始为1

            queue.add(beginWord);
            lists.add(beginWord);
            // 用null 隔开，当前字符串节点遍历结束，没有找到相关字符串
            queue.add(null);

            while (!queue.isEmpty()) {

                String cur = queue.poll();
                if (cur == null) {
                    if (!queue.isEmpty()) {
                        // 进入下一层
                        count++;
                        queue.add(null);
                    }

                } else {
                    char chars[] = cur.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        char o = chars[i];
                        for (char c = 'a'; c <= 'z'; c++) {

                            chars[i] = c;
                            String str = new String(chars);
                            if (endWord.equals(str) && wordList.contains(str)) {
                                return count + 1;
                            } else if (!lists.contains(str) && wordList.contains(str)) {
                                lists.add(str);
                                queue.add(str);
                            }
                        }
                        chars[i] = o;
                    }
                }


            }


            return 0;
        }*/
    public static void main(String args[]) {

        /**
         * "hit"
         "cog"
         ["hot","dot","dog","lot","log","cog"]
         */

        String begin = "hit";
        String end = "cog";
        String str[] = new String[6];
        str[0] = "hot";
        str[1] = "dot";
        str[2] = "dog";
        str[3] = "lot";
        str[4] = "log";
        str[5] = "cog";


         /*

         "hit"
         "cog"
         ["hot","dot","dog","lot","log"]

        String begin = "hit";
        String end = "cog";
        String str[] = new String[5];
        str[0] = "hot";
        str[1] = "dot";
        str[2] = "dog";
        str[3] = "lot";
        str[4] = "log";*/

        List<String> lists = Arrays.asList(str);
        WordLadder w = new WordLadder();

        System.out.println(w.ladderLength(begin, end, lists));

    }


}
