import java.util.*;

public class SortByFrequency {
    public static void main(String[] args) {
        System.out.println(sortByFrequency("tree"));
    }
    static String sortByFrequency(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );
        pq.addAll(map.keySet());
        StringBuilder str = new StringBuilder();

        while(!pq.isEmpty()) {
            char ch = pq.poll();
            int freq = map.get(ch);

            for (int i = 0; i < freq; i++) {
                str.append(ch);
            }
        }
        return str.toString();
    }
}
