
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(squareRoot(60));
    }
    static int squareRoot(int n) {
        int start = 1;
        int end = n;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid * mid <= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
