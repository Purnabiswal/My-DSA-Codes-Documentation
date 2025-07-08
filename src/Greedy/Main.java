package src.Greedy;

public class Main {
    public static void main(String[] args) throws Exception {

        String str="abbccda";
        HuffmanCoder hf=new HuffmanCoder(str);
        String cs= hf.encode(str);
        System.out.println(cs);
        String ds= hf.decode(cs);
        System.out.println(ds);

        //Bitset can be used: It's like an array but with a bit at each index

    }
}
