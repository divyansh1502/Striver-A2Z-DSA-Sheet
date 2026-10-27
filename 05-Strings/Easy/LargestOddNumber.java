public class LargestOddNumber {
    public static void main(String[] args) {
        String s = "0002457894";
        System.out.println(largestOddNumber(s));
    }
    static String largestOddNumber(String s) {
        int start = 0;
        while(start < s.length() - 1 && s.charAt(start) == '0') start++;
        for (int i = s.length() - 1; i >= start; i--) {
            if(s.charAt(i) % 2 == 1) {
                return s.substring(start, i + 1);
            } 
        }
        return "";
    }
}