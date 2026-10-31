public class InsertionAtGivenPosition {
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(40);
        Node fourth = new Node(50);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node head = first;

        Node newNode = new Node(30);

        int position = 2;

        Node current = head;
        int counter = 1;

        while(current != null && counter < position) {
            counter++;
            current = current.next;
        }
        
        // Preserve the remaining linked list
        newNode.next = current.next;

        // Connect previous node to new node
        current.next = newNode;

        // Traversal
        current = head;
        
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}