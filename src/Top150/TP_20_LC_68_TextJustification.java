package src.Top150;

import java.util.ArrayList;
import java.util.List;

public class TP_20_LC_68_TextJustification {
    public static void main(String[] args) {
//        String[] words={"This", "is", "an", "example", "of", "text", "justification."};
        String[] words={"What","must","be","acknowledgment","shall","be"};
//        String[] words={"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};

        int maxWidth = 16;

        List<String> list=fullJustify(words, maxWidth);
        for (String e: list){
            System.out.println(e);
        }


    }


    static public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list=new ArrayList<>();
        int n= words.length;
        int i = 0;
        while (i < n) {

            int len=0, word_count=0, j=i;
            while (j<n && (len+words[j].length()+word_count)<=maxWidth){
                len=len+words[j].length();
                j++;
                word_count++;
            }

            if ((word_count+i)>=n){
                StringBuilder line=new StringBuilder();
                int count=0;
                for (int k = i; k < word_count+i-1; k++) {
                    line.append(words[k]).append(" ");
                    count+=words[k].length()+1;
                }
                line.append(words[word_count+i-1]);
                count+=words[word_count+i-1].length();
                for (int k = count; k < maxWidth; k++) {
                    line.append(" ");
                }
                list.add(line.toString());
                i+=word_count;
                continue;
            }

            if (word_count == 1) {
                StringBuilder line = new StringBuilder(words[i]);
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
                list.add(line.toString());
                i++;
                continue;
            }
            int avl_spaces=maxWidth-len;
            int no_space=0;
            int extra_spaces_in_left=0;
            if((word_count-1)>0){
                no_space=(avl_spaces/(word_count-1));
                extra_spaces_in_left=(avl_spaces%(word_count-1));
            }


            StringBuilder temp=new StringBuilder();
            for (int k = 0; k < no_space; k++) {
                temp.append(" ");
            }
            String space=temp.toString();


            StringBuilder line=new StringBuilder();

            for (int k = i; k < word_count+i-1; k++) {
                line.append(words[k]).append(space);
                if (extra_spaces_in_left>0){
                    line.append(" ");
                    extra_spaces_in_left--;
                }
            }
            line.append(words[word_count+i-1]);


            i+=word_count;
            String line_str=line.toString();


            list.add(line_str);

        }
        return list;
    }


}
