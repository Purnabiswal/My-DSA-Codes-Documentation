package src.Top150.T5_Hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class T1_LC383_RansomNote {
    public static void main(String[] args) {
//        String ransomNote = "a", magazine = "b";
//        String ransomNote = "aa", magazine = "aab";
        String ransomNote = "aa", magazine = "ab";
        System.out.println(canConstruct(ransomNote, magazine));
        System.out.println(canConstruct2(ransomNote, magazine));
        System.out.println(canConstruct3(ransomNote, magazine));
        System.out.println(canConstruct4(ransomNote, magazine));

    }

    //Efficient
    public static boolean canConstruct4(String ransomNote, String magazine) {
        int[] count = new int[26];

        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    //Efficient: Using Hashmap
    public static boolean canConstruct3(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        HashMap<Character, Integer> need = new HashMap<>();

        for (char c : ransomNote.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int remaining = ransomNote.length();

        for (char c : magazine.toCharArray()) {
            Integer count = need.get(c);

            if (count != null && count > 0) {
                need.put(c, count - 1);
                remaining--;

                if (remaining == 0) {
                    return true; // all characters found
                }
            }
        }

        return false;
    }


    static public boolean canConstruct2(String ransomNote, String magazine) {
        char[] chars=ransomNote.toCharArray();

        HashMap<Character, Integer> map=new HashMap<>();
        for (char aChar : magazine.toCharArray()) {
            map.put(aChar, map.getOrDefault(aChar, 0)+1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.getOrDefault(chars[i], 0)==0){
                return false;
            }
            map.put(chars[i], map.get(chars[i])-1);
        }
        return true;
    }

    static public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars=ransomNote.toCharArray();

        HashMap<Character, Integer> map=new HashMap<>();
        for (char aChar : magazine.toCharArray()) {
            map.put(aChar, map.getOrDefault(aChar, 0)+1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char key = chars[i];
            if (!map.containsKey(key)){
                return false;
            }
            int value=map.get(key);
            if (value>1) {
                map.put(key, value-1);
            }else {
                map.remove(key);
            }

        }
        return true;
    }

}
