public class PaintersPartition {

    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};
        int painters = 2;

        System.out.println(minTime(boards, painters));
    }

    static int minTime(int[] boards, int k) {
        int low = 0;
        int high = 0;

        for (int board : boards) {
            low = Math.max(low, board);
            high += board;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int paintersNeeded = countPainter(boards, mid);

            if (paintersNeeded > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    static int countPainter(int[] boards, int maxTimeAllowed) {
        int paintersNeeded = 1;
        int currentTime = 0;

        for (int board : boards) {
            if (currentTime + board <= maxTimeAllowed) {
                currentTime += board;
            } else {
                currentTime = board;
                paintersNeeded++;
            }
        }

        return paintersNeeded;
    }
}