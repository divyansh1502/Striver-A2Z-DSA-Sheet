public class PascalsTriangleIndividualElement {

    public static void main(String[] args) {

        // Find the element at row = 4, column = 3
        // Pascal's Triangle uses 1-based indexing.
        // So, (4, 3) → C(4 - 1, 3 - 1) → C(3, 2) = 3
        System.out.println(pascalTriangle(4, 3));
    }

    // Returns the element at the given row and column
    // in Pascal's Triangle.
    public static int pascalTriangle(int row, int col) {

        // Pascal's Triangle is based on:
        // Element(row, col) = C(row - 1, col - 1)
        return nCr(row - 1, col - 1);
    }

    // Calculates nCr (n choose r)
    //
    // Formula:
    // nCr = n! / (r! * (n-r)!)
    //
    // Instead of calculating factorials, we calculate
    // the result step-by-step to avoid unnecessary work.
    static int nCr(int n, int r) {

        // nC0 is always 1
        int result = 1;

        // C(n, r) = C(n, n-r)
        // Using the smaller r reduces the number of iterations.
        r = Math.min(r, n - r);

        for (int i = 0; i < r; i++) {

            // Multiply by the next numerator:
            // n, n-1, n-2, ...
            result = result * (n - i);

            // Divide by:
            // 1, 2, 3, ...
            //
            // This keeps the calculation equivalent to nCr.
            result = result / (i + 1);
        }

        return result;
    }
}

