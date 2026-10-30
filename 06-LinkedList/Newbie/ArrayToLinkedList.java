
public class ArrayToLinkedList {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        Node head = linkedList(arr);

        //Traversal
        Node current = head;

        while(current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }
    static Node linkedList(int[] arr) {

        if(arr.length == 0) {
            return null;
        }

        //create the first node
        Node head = new Node(arr[0]);

        //current points to the same node as head
        Node current = head;
        
        //start from index 1 bcz index 0 is already processed
        for (int i = 1; i < arr.length; i++) {

            Node newNode = new Node(arr[i]);

            //connect the current node to the new node
            current.next = newNode;

            // Move current node forward
            current = newNode;
        }

        return head;
    }
}
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
