
public class MaximumDepthOfParentheses {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
    static int maxDepth(String s) {
        int counter = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                counter++;
                max = Math.max(max, counter);
            }
            if(s.charAt(i) == ')') {
                counter--;
            }
        }
        return max;
    }
}
