package src.HashMaps_16.MyImplementation;

public class Main {
    public static void main(String[] args) {
//        String name="Rahul";
//        int code=name.hashCode();
//        Integer a=106572;
//        int code2=a.hashCode();
//        System.out.println(code);
//        System.out.println(code2);


//        HashMap<String, Integer> map=new HashMap<String, Integer>();
//        map.put("Purna", 88);
//        map.put("Kunal", 99);
//        map.put("Karan", 94);
//        map.put("Rahul", 95);
//        map.put("Rahul", 9);
//
//
//        System.out.println(map);
//        System.out.println(map.get("Karan"));
//        System.out.println(map.getOrDefault("Karan", 7777));
//        System.out.println(map.getOrDefault("karan", 7777));
//        System.out.println(map.containsKey("Rahul"));

//        HashSet<Integer> set = new HashSet<>();
//        System.out.println(set.add(36));
//        System.out.println(set.add(39));
//        System.out.println(set.add(45));
//        System.out.println(set.add(4));
//        System.out.println(set.add(36));
//        System.out.println(set);


        //treemap will sort by keys
//        TreeMap<Integer, String> treeMap=new TreeMap<>();
//        treeMap.put(98, "Purna");
//        treeMap.put(24, "Pop");
//        treeMap.put(36, "Kunal");
//        treeMap.put(89, "Upper");
//
//        System.out.println(treeMap);



//        MapUsingHash myMap=new MapUsingHash();
//        myMap.put("Purna", "88");
//        myMap.put("Kunal", "94");
//        myMap.put("karan", "98");
//        myMap.put("cuva", "99");
//        System.out.println(myMap.get("Purna"));
//        myMap.remove("jgdhg");
//        System.out.println(myMap.get("Kunal"));
//        System.out.println(myMap.get("karan"));
//        System.out.println(myMap.get("cuva"));
//
//        System.out.println("lod".hashCode());
//        myMap.put("", "96");
//        System.out.println(myMap.get("Kunal"));

        HashMapFinal<String, String> myMap=new HashMapFinal<>();
        myMap.put("Purna", "88");
        myMap.put("Kunal", "94");
        myMap.put("karan", "98");
        myMap.put("cuva", "99");
        myMap.put("smith", "99");
        myMap.put("jiva", "99");
        myMap.put("suva", "99");
        myMap.put("next", "99");
        myMap.put("prim", "99");
        myMap.put("level", "99");
        System.out.println(myMap.get("Purna"));
        //myMap.remove("jgdhg");
        System.out.println(myMap.get("Kunal"));
        System.out.println(myMap.get("karan"));
        System.out.println(myMap.get("cuva"));

        System.out.println("lod".hashCode());
        System.out.println(myMap.get("Kunal"));

        System.out.println(myMap);

    }
}
