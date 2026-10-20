import java.util.Arrays;
public class PeakElementIn2DMatrix {
    public static void main(String[] args) {
        int[][] mat = {
            {10, 20, 15},
            {21, 30, 14},
            {7, 16, 32}
        };

        int[] result = findPeakGrid(mat);

        System.out.println("Peak element index: " + Arrays.toString(result));
        System.out.println("Peak element value: " + mat[result[0]][result[1]]);
    }
    public static int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int low = 0;
        int high = cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxRows = 0;

            for (int i = 0; i < rows; i++) {
                if (mat[i][mid] > mat[maxRows][mid]) {
                    maxRows = i;
                }
            }

            int left = (mid > 0) ? mat[maxRows][mid - 1] : -1;
            int right = (mid < cols - 1) ? mat[maxRows][mid + 1] : -1;

            if (mat[maxRows][mid] > left && mat[maxRows][mid] > right) {
                return new int[]{maxRows, mid};
            } else if (mat[maxRows][mid] < right) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
}