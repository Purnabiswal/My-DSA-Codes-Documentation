package src.Miscellaneous_13;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {

        String beginWord = "zog";
        String endWord = "cog";
        String[] strings = {"cog","hot","dot","dog","lot","log"};

        List<String> wordList = new ArrayList<>(Arrays.asList(strings));

        System.out.println(ladderLength(beginWord, endWord, wordList));


    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        int ans=0;
        int n=beginWord.length();
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        
        while (!queue.isEmpty()){
            ans++;
            int len= queue.size();
            for (int j = 0; j < len; j++) {
                String str=queue.poll();
                //for word length
                for (int i = 0; i < n; i++) {
                    StringBuilder word=new StringBuilder(str);
                    //for each character check from a to z
                    for (char ch='a';ch<='z';ch++){
                        word.setCharAt(i,ch);
                        if (set.contains(word.toString())){
                            if (word.toString().equals(endWord)){
                                return ans;
                            }
                            queue.add(word.toString());
                            set.remove(word.toString());
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}
