import java.util.*;

public class IsomorphicString {
    public static void main(String[] args) {
        System.out.println(isomorphicString("egg", "add"));
    }
    static boolean isomorphicString(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(mapS.containsKey(a) && mapS.get(a) != b) return false;
            if(mapT.containsKey(b) && mapT.get(b) != a) return false;

            mapS.put(a, b);
            mapT.put(b, a);
        }
        return true;
    }
}
