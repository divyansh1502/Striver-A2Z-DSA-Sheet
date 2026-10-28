public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isValid("anagram", "nagamar"));
    }   
    static boolean isValid(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int count : freq) {
            if(count != 0) return false;
        }
        return true;
    }
}
