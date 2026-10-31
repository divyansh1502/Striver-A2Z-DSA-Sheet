
public class DeleteGivenPosition {
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node head = first;

        int position = 3;

        int counter = 0;

        Node current = head;

        while(current.next != null && counter < position - 2) {
            counter++;
            current = current.next;
        }
        current.next = current.next.next;

        current = head;

        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
