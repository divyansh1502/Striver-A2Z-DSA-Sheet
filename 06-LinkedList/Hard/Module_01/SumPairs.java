import java.util.ArrayList;
import java.util.Arrays;

public class SumPairs {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;

        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;

        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        int target = 7;

        ArrayList<ArrayList<Integer>> result = sumPair(head, target);

        System.out.println(result);
    }

    static ArrayList<ArrayList<Integer>> sumPair(Node head, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        Node right = head;

        while (right != null && right.next != null) {
            right = right.next;
        }

        Node left = head;

        while (left != null && right != null && left.data < right.data) {
            int sum = left.data + right.data;

            if (sum == target) {
                list.add(new ArrayList<>(Arrays.asList(left.data, right.data)));
                left = left.next;
                right = right.prev;
            } else if (sum < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        return list;
    }
}