package src.Top150;

import src.T_20_Implementation.RandomizedSet;

public class TP_9_LC_380 {
    public static void main(String[] args) {

        RandomizedSet rs = new RandomizedSet();

        System.out.println(rs.remove(0));   // false
        System.out.println(rs.remove(0));   // false
        System.out.println(rs.insert(0));   // true
        System.out.println(rs.getRandom()); // 0
        System.out.println(rs.remove(0));   // true
        System.out.println(rs.insert(0));   // true
    }


}
