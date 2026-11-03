
public class LinkedListLength {
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

        int counter = 0;

        while(current != null) {
            counter++;
            current = current.next;
        }
        System.out.println("Length of LinkList is : " + counter);
    }
}
