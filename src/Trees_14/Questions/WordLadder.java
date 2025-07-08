package src.Trees_14.Questions;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        String[] strings = {"hot","dot","dog","lot","log","cog"};

        List<String> wordList = new ArrayList<>(Arrays.asList(strings));

        System.out.println(ladderLength(beginWord, endWord, wordList));


    }

    //TC: O((N^2)*m)   where m is the length of word
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        if (!wordList.contains(endWord)){
            return 0;
        }
        int ans=0;
        int n=beginWord.length();
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        
        while (!queue.isEmpty()){
            ans++;
            int len = queue.size();
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
                                return ans+1;
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


    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        if (!wordList.contains(endWord)){
            return 0;
        }
        int ans=0;
        int n=beginWord.length();
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()){
            ans++;
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                String str=queue.poll();
                //for word length
                for (int i = 0; i < n; i++) {
                    char[] word=str.toCharArray();
                    //for each character check from a to z
                    for (char ch='a';ch<='z';ch++){
                        word[i]=ch;
                        //word.setCharAt(i,ch);
                        String newWord=new String(word);
                        if (set.contains(newWord)){
                            if (newWord.equals(endWord)){
                                return ans+1;
                            }
                            queue.add(newWord);
                            set.remove(newWord);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
