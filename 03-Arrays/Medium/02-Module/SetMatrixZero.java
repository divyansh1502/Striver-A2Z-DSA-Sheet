public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 1, 1, 1,},
            {1, 1, 0, 1,},
            {1, 0, 1, 1,},
            {1, 1, 1, 1,}
        };
        zeroMatrix(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void zeroMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
