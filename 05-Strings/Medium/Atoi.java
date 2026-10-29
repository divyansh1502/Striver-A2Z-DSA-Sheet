public class Atoi {
    public static void main(String[] args) {
        System.out.println(stringToInteger("   -452kj6"));
    }
    static int stringToInteger(String s) {
        int i = 0;
        int num = 0;
        int sign = 1;
        int n = s.length();

        while(i < n && s.charAt(i) == ' ') {
            i++;
        }

        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if(s.charAt(i) == '-') {
                sign = -1;
            } 
            i++;
        }

        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';
            if(num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }
}