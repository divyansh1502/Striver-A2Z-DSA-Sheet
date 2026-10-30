public class InsertionAtTheEnd {
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node head = first;

        Node newNode = new Node(5);

        Node current = head;

        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;

        current = head;

        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}