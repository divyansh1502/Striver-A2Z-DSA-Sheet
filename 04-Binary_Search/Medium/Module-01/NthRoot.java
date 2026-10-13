
public class NthRoot {
    public static void main(String[] args) {
        System.out.println(nRoot(3, 27));
    }
    // m ---> Power && n ---> num
static int nRoot(int m, int n) {
    long start = 1;
    long end = n;

    while(start <= end) {
        long mid = start + (end - start) / 2;
        long result = findRoot(m, n, mid);

        if(mid != 0 && result == 1) {
            return (int)mid;
        } else if(result == 2) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return -1;
}
    static int findRoot(int m, int n, long mid) {
        long result = 1;

        for (int i = 0; i < m; i++) {
            if(result > n / mid) {
                return 2;
            }
            result *= mid;
        }
        if(result == n) return 1;
        return 0;
    }
}