package src.Heaps_15;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.*;

//TC: O(nlogn)
public class HuffmanCoder {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    public class Node implements Comparable<Node> {
        Character data;
        int cost; //frequency
        Node left;
        Node right;

        public Node(char data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left=null;
            this.right=null;
        }



        @SuppressWarnings("GrazieInspection")
        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;     //node1.compareTo(node2) < 0
                                               //this            other
            //return value -ve means this.cost is smaller
        }
    }

    public HuffmanCoder(String feeder) throws Exception {
        //create a frequency map for all characters
        HashMap<Character, Integer> fmap=new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            char ch=feeder.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0)+1);
        }

        //create min heap and create nodes for all elements in the frequency map: fmap
        PriorityQueue<Node> minheap=new PriorityQueue<>();

        //To iterate over the fmap use entrySet
        Set<Map.Entry<Character, Integer>> entrySet = fmap.entrySet();

        for (Map.Entry<Character, Integer> entry : entrySet){
            Node node = new Node(entry.getKey(), entry.getValue());
            minheap.add(node);
        }


        while (minheap.size()!=1){
            //Remove 2 smallest elements
            Node first=minheap.remove();
            Node second=minheap.remove();
            //combine them in a new node
            Node newNode=new Node('\0', first.cost+second.cost);
            newNode.left=first;
            newNode.right=second;
            //add the new node to min heap
            minheap.add(newNode);
        }
        Node ft=minheap.remove(); //Tree's top element. //using this create encoder and decoder

        this.encoder=new HashMap<>();
        this.decoder=new HashMap<>();
        this.initEncoderDecoder(ft, "");
    }

    private void initEncoderDecoder(Node node, String osf){ //osf: output so far
        if (node==null){
            return;
        }
        if (node.left==null && node.right==null){
            this.encoder.put(node.data, osf);
            this.decoder.put(osf, node.data);
        }

        //preorder
        initEncoderDecoder(node.left,osf+"0");
        initEncoderDecoder(node.right,osf+"1");
    }


    public String encode(String source){
        StringBuilder st=new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char ch=source.charAt(i);
            st.append(encoder.get(ch));
        }
        return st.toString();
    }

    public String decode(String codedString){
        StringBuilder st=new StringBuilder();
        StringBuilder key=new StringBuilder();
        for (int i = 0; i < codedString.length(); i++) {
            key.append(codedString.charAt(i));
            Character ans=decoder.get(key.toString());
            if (ans!=null){
                st.append(ans);
                key.setLength(0);
            }
        }
        return st.toString();
    }
}
