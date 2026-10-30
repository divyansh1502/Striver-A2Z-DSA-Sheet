
public class TraverseLinkedList {
    public static void main(String[] args) {

        // Creation of Nodes 
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        // Connection of nodes
        first.next = second;
        second.next = third;
        third.next = fourth;

        Node head = first;

        Node temp = head;

        // Traversal
        while(temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
    
}
