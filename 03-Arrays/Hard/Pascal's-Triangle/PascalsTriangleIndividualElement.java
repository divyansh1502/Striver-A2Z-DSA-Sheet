public class PascalsTriangleIndividualElement {

    public static void main(String[] args) {

        System.out.println(pascalTriangle(4, 3));
    }

    public static int pascalTriangle(int row, int col) {

        // Element(row, col) = C(row - 1, col - 1)
        return nCr(row - 1, col - 1);
    }
    static int nCr(int n, int r) {

        int result = 1;
        r = Math.min(r, n - r);

        for (int i = 0; i < r; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }

        return result;
    }
}

