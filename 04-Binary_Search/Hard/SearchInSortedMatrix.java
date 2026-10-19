
public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {7, 9, 11},
            {13, 15, 17}
        };

        int target = 15;

        boolean found = searchMatrix(matrix, target);

        System.out.println("Target found: " + found);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = (rows * cols) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}

