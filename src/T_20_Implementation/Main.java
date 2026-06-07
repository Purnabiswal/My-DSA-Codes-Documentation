package src.T_20_Implementation;

public class Main {
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