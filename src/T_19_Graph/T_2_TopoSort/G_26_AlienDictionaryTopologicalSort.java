package src.T_19_Graph.T_2_TopoSort;

import java.util.*;

//https://www.geeksforgeeks.org/problems/alien-dictionary/1
//https://www.naukri.com/code360/problems/alien-dictionary_7411713
//https://leetcode.com/problems/alien-dictionary/editorial/ - premium one
public class G_26_AlienDictionaryTopologicalSort {
    public static void main(String[] args) {

//        String[] words={"baa", "abcd", "abca", "cab", "cad"};
//        String[] words={"wrt", "wrf", "er", "ett","rftt"};
        String[] words={"abc", "ab"};
        G_26_AlienDictionaryTopologicalSort ob=new G_26_AlienDictionaryTopologicalSort();
        System.out.println(ob.findOrder(words));

    }


    //naukri.com
    public static String getAlienLanguage(String []words, int n) {



        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length-1; i++) {
            for (int j = 0; j < words[i].length() && j < words[i+1].length(); j++) {
                char ch1=words[i].charAt(j);
                char ch2=words[i+1].charAt(j);
                if (ch1!=ch2){
                    int x=ch1-97;
                    int y=ch2-97;
                    adj.get(x).add(y);
                    break;
                }
            }
        }

        int[] in_degree=new int[n];
        Queue<Integer> queue=new LinkedList<>();
        StringBuilder s= new StringBuilder();

        for (ArrayList<Integer> arr:adj){
            for (int e:arr){
                in_degree[e]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (in_degree[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int node=queue.poll();
            char ch=(char) (node+97);
            s.append(ch);

            for (int nei:adj.get(node)){
                in_degree[nei]--;
                if (in_degree[nei]==0){
                    queue.add(nei);
                }
            }
        }

        if (s.length()!=n) return "";

        return s.toString();
    }



    //gfg
    public String findOrder(String[] words) {
        ArrayList<Character> list=new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char ch=words[i].charAt(j);
                if (!list.contains(ch)){
                    list.add(ch);
                }
            }
        }
        Collections.sort(list);
        int n=list.size();

//        System.out.println(n);
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length-1; i++) {
            String word1=words[i];
            String word2=words[i+1];
            int len=Math.min(word1.length(), word2.length());
            for (int j = 0; j <= len; j++) {
                if (j==len && word1.length()>word2.length()) return "";
                if (j==len) break;
                char ch1=words[i].charAt(j);
                char ch2=words[i+1].charAt(j);
                if (ch1!=ch2){
                    int x= list.indexOf(ch1);
                    int y=list.indexOf(ch2);
                    adj.get(x).add(y);
                    break;
                }
            }
        }

        int[] in_degree=new int[n];
        Queue<Integer> queue=new LinkedList<>();
        StringBuilder s= new StringBuilder();

        for (ArrayList<Integer> arr:adj){
            for (int e:arr){
                in_degree[e]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (in_degree[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int node=queue.poll();
            char ch=list.get(node);
            s.append(ch);

            for (int nei:adj.get(node)){
                in_degree[nei]--;
                if (in_degree[nei]==0){
                    queue.add(nei);
                }
            }
        }

        if (s.length()!=n) return "";

        return s.toString();
    }


    //correct solution
    public String findOrder2(String[] words) {

        int N = words.length;

        // 1) Collect all unique characters
        HashSet<Character> set = new HashSet<>();
        for (String w : words) {
            for (char ch : w.toCharArray()) {
                set.add(ch);
            }
        }

        // 2) Create mapping char -> index
        ArrayList<Character> chars = new ArrayList<>(set);
        Collections.sort(chars); // optional, for stable output

        int K = chars.size();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            map.put(chars.get(i), i);
        }

        // 3) Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());
            int j = 0;

            while (j < len && w1.charAt(j) == w2.charAt(j)) j++;

            // prefix invalid: "abc" then "ab"
            if (j == len && w1.length() > w2.length()) return "";

            if (j < len) {
                int u = map.get(w1.charAt(j));
                int v = map.get(w2.charAt(j));
                adj.get(u).add(v);
            }
        }

        // 4) Kahn’s topological sort
        int[] indeg = new int[K];
        for (int i = 0; i < K; i++) {
            for (int v : adj.get(i)) indeg[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(chars.get(node));

            for (int nei : adj.get(node)) {
                indeg[nei]--;
                if (indeg[nei] == 0) q.add(nei);
            }
        }

        // Cycle check
        if (sb.length() != K) return "";

        return sb.toString();
    }



}
