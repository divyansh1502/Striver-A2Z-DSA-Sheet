
import java.util.*;

public class SubstringWithKDistinct {
    public static void main(String[] args) {
        System.out.println(countSubstr("ABAC", 2));
    }
    static int countSubstr(String s, int k) {
        return atMostK(s, k) - atMostK(s, k - 1);
    }
    static int atMostK(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;

        for(int right = 0; right < s.length(); right++) {
            char chR = s.charAt(right);
            map.put(chR, map.getOrDefault(chR, 0) + 1);

            while(map.size() > k) {

                char chL = s.charAt(left);
                map.put(chL, map.get(chL) - 1);

                if(map.get(chL) == 0) {
                    map.remove(chL);
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
