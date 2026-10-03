import java.util.Arrays;

public class PascalsTriangleIndividualRow {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(returnRow(6)));
    }
    public static int[] returnRow(int r) {
        return printRow(r - 1, r - 1);
    }
    static int[] printRow(int n, int r) {
        int ans[] = new int[n + 1];
        ans[0] = 1;
        int res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1);
            res = res / i;
            ans[i] = res;
        }
        return ans;
    }
}



/* ------------------> LeetCode

class Solution {
    public List<Integer> getRow(int rowIndex) {
        return printRow(rowIndex, rowIndex);
    }
    List<Integer> printRow(int n, int r) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        long res = 1;
        for(int i = 1; i <= r; i++) {
            res = res * (n - i + 1);
            res = res / i;
            list.add((int)res);
        }
        return list;
    }
}

*/