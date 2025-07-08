package src.HashMaps_16;

//Hashing series
public class KarpRabin {
    private final int PRIME=101;



    private double calculateHash(String str){
        double hash=0;
        for (int i = 0; i < str.length(); i++) {
            hash+= (str.charAt(i)*Math.pow(PRIME,i));
        }
        return hash;
    }

    private double updateHash(double prevHash, char oldChar, char newChar, int patternLength){
        double newHash=(prevHash-oldChar)/PRIME;
        newHash+=(newChar*Math.pow(PRIME, patternLength-1));
        return newHash;
    }

    public void search(String text, String pattern){
        int patternLength=pattern.length();
        double textHash=calculateHash(text.substring(0,patternLength));
        double patternHash=calculateHash(pattern);

        for (int i = 0; i<=(text.length()-patternLength); i++) {
            if (textHash==patternHash){
                //check strings match now
                boolean isMatch=true;
                for (int j=0;j<patternLength;j++){
                    if (text.charAt(i+j)!=pattern.charAt(j)){
                        isMatch=false;
                        break;
                    }
                }
                if (isMatch){
                    System.out.println("we got em!! at index "+ i);
                    break;
                }
            }
            if (i<text.length()-patternLength){
                textHash=updateHash(textHash, text.charAt(i), text.charAt(i+patternLength), patternLength);
            }
        }
    }








    public static void main(String[] args) {
        KarpRabin algo=new KarpRabin();
        algo.search("ApoorvRahulKunal", "Kunal");
    }
}
