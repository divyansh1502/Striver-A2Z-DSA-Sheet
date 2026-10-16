public class BookAllocationProblem {
    public static void main(String[] args) {
        int[] books = {1, 2, 3, 4, 5};
        System.out.println(findPages(books, 3));
    }
    public static int findPages(int[] books, int students) {
        if(students > books.length) return -1;

        int low = 0;
        int high = 0;

        for(int pages : books) {
            low = Math.max(low, pages);
            high += pages;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int studentNeeded = countStudent(books, mid);

            if(studentNeeded > students) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    static int countStudent(int[] books, int maxAllowedPages) {
        int studentNeeded = 1;
        int currentPages = 0;

        for(int pages : books) {
            if(currentPages + pages <= maxAllowedPages) {
                currentPages += pages;
            } else {
                studentNeeded++;
                currentPages = pages;
            }
        }
        return studentNeeded;
    }
}
