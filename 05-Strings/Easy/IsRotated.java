public class IsRotated {
    public static void main(String[] args) {
        System.out.println(isRotated("abcdef", "defabc"));
    }
    static boolean isRotated(String s, String goal) {
        if(s.length() != goal.length()) return false;

        return (s + s).contains(goal);
    }
}
