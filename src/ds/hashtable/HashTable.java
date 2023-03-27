package ds.hashtable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
public class HashTable {

    public static void main(String[] args) {
        System.out.println("hello world");

        HashMap<String,String> map = new HashMap<>();
        /*https://www.geeksforgeeks.org/internal-working-of-hashmap-java/
        https://medium.com/swlh/hashmap-implementation-for-java-90a5f58d4a5b
        https://dzone.com/articles/custom-hashmap-implementation-in-java
        https://leetcode.com/problems/design-hashmap/
        https://www.javatpoint.com/working-of-hashmap-in-java
        https://www.javatpoint.com/collections-in-java
        https://www.javatpoint.com/java-map
        https://www.geeksforgeeks.org/differences-between-hashmap-and-hashtable-in-java/
        https://stackoverflow.com/questions/12104938/java-collection-not-have-map-as-part-of-collection-framework*/

        //Hashtable
        map.put("asd","asdas");
        System.out.println(map.hashCode());
        System.out.println(System.identityHashCode(map));
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        ht.get(1);

        ConcurrentHashMap<Integer, Integer> cmap = new ConcurrentHashMap<>();
        cmap.get(1);
        cmap.put(1,1);

        Map.Entry<Integer, Integer>[] a;
        LinkedHashMap<Integer,Integer> la = new LinkedHashMap<>();
        la.put(1, 1);
        la.get(1);
        la.remove(1);
        la.entrySet();

        HashSet<Integer> s = new HashSet<>();
        s.add(1);

        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        tmap.put(1,1);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);

        ArrayList<Integer> l = new ArrayList<>();


    }
}
