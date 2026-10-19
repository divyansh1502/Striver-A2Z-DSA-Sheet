
public class RowWithMaximumOnes {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 1, 1},
            {0, 0, 0, 1},
            {0, 1, 1, 1},
            {0, 0, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        };

        System.out.println(rowWithMax1s(matrix));
    }
    public static int rowWithMax1s(int[][] matrix) {
        int rowIndex = -1;
        int maxOnes = 0;

        for (int i = 0; i < matrix.length; i++) {
            int firstOneIndex = lowerBound(matrix[i]);
            int currentOnes = matrix[i].length - firstOneIndex;

            if (currentOnes > maxOnes) {
                rowIndex = i;
                maxOnes = currentOnes;
            }
        }

        return rowIndex;
    }

    public static int lowerBound(int[] row) {
        int low = 0;
        int high = row.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] >= 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
