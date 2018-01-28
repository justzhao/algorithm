package com.zhaopeng.question.StringQ;

import java.util.*;

/**https://leetcode.com/problems/word-ladder/
 * Created by zhaopeng on 2017/5/28.
 */
public class WordLadder {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int count=map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] words = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    words[i]=j;
                    String temp=new String(words);
                    if(set.contains(temp)){
                        if(temp.equals(endWord)){
                            return count+1;
                        }
                        map.put(temp,count+1);
                        queue.offer(temp);
                        set.remove(temp);
                    }
                }
            }
        }
        return 0;
    }


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
