
public class FindTarget {
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node head = first;

        Node current = head;

        int target = 30;

        boolean found = false;

        while(current != null) {
            if(current.data == target) {
                found = true;
                break;
            }
            current = current.next;
        }
        if(found) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}
