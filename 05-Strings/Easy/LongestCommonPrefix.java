import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"Flower", "Flow", "Fly"};
        System.out.println(commonPrefix(arr));
    }
    static String commonPrefix(String[] str) {
        Arrays.sort(str);
        String a = str[0];
        String b = str[str.length - 1];

        int index = a.length();

        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                index = i;
                break;
            }
        }
        return a.substring(0, index);
    }
}
