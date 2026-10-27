public class ReverseWords {
    public static void main(String[] args) {
        String s = "Humpty Dumpty sat     on a Wall";
        System.out.println(reverseWords(s));
    }
    static String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder str = new StringBuilder();
        reverse(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            if(i > 0) str.append(" ");
            str.append(arr[i]);
        }
        return str.toString();
    }
    static void reverse(String[] arr, int i, int j) {
        while(i < j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
