public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("acbadabcemkmecbad154jd"));
    }
    static String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 0;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            
            int left = i;
            int right = i;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                
                len = right - left + 1;

                if(len > maxLen) {
                    maxLen = len;
                    start = left;
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                
                len = right - left + 1;

                if(len > maxLen) {
                    maxLen = len;
                    start = left;
                }
                left--;
                right++;
            }

        }
        return s.substring(start, start + maxLen);
    }
}
