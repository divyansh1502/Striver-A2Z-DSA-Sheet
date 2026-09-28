
import java.util.*;

public class Test {
    public static void main(String[] args) {
        
        longestSubarray("aabaacbbbbbdaskjhfdasbjkkADSJGJKLAskjlaSBJKBJKACsbjklacSBJACsbjklbhjklacSBHJLACsbhjladsbhjlbhjlacsBHJACsvbhjacSbbciaaib");
    }
    public static void longestSubarray(String s) {

       Map<Character, Integer> map = new HashMap<>();
       for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
       }
       System.out.println(map);
    }
}
