import java.util.HashSet;
import java.util.Set;

public class FirstIntersectionPoint {
    public static void main(String[] args) {

        // Common part
        Node common = new Node(8);
        common.next = new Node(10);

        // List A: 1 -> 2 -> 8 -> 10
        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = common;

        // List B: 3 -> 4 -> 5 -> 8 -> 10
        Node headB = new Node(3);
        headB.next = new Node(4);
        headB.next.next = new Node(5);
        headB.next.next.next = common;

        Node ans1 = getIntersectionNode(headA, headB);
        Node ans2 = getIntersectionNode2(headA, headB);
        Node ans3 = getIntersectionNode3(headA, headB);

        System.out.println("Two Pointer: " + (ans1 != null ? ans1.data : -1));
        System.out.println("Length Difference: " + (ans2 != null ? ans2.data : -1));
        System.out.println("HashSet: " + (ans3 != null ? ans3.data : -1));
    }

    // 1. OPTIMAL — TWO POINTER SWITCHING
    // TC: O(N + M) | SC: O(1)

    static Node getIntersectionNode(Node headA, Node headB) {
        Node h1 = headA;
        Node h2 = headB;

        while(h1 != h2) {
            if(h1 == null) h1 = headB;
            else h1 = h1.next;

            if(h2 == null) h2 = headA;
            else h2 = h2.next;
        }
        return h1;
    }


    // 2. LENGTH DIFFERENCE
    // TC: O(N + M) | SC: O(1)

    static Node getIntersectionNode2(Node headA, Node headB) {
        int lengthA = 0, lengthB = 0;

        Node currA = headA;
        Node currB = headB;

        while(currA != null) {
            lengthA++;
            currA = currA.next;
        }

        while(currB != null) {
            lengthB++;
            currB = currB.next;
        }

        int lengthDiff = Math.abs(lengthA - lengthB);

        currA = headA;
        currB = headB;

        if(lengthA > lengthB)
            return findIntersection(currA, currB, lengthDiff);

        return findIntersection(currB, currA, lengthDiff);
    }

    static Node findIntersection(Node longerList, Node shorterList, int nodesToSkip) {
        for(int i = 0; i < nodesToSkip; i++)
            longerList = longerList.next;

        while(longerList != null) {
            if(longerList == shorterList) return longerList;

            longerList = longerList.next;
            shorterList = shorterList.next;
        }

        return null;
    }


    // 3. HASHSET
    // TC: O(N + M) Average | SC: O(N)

    static Node getIntersectionNode3(Node headA, Node headB) {
        Set<Node> set = new HashSet<>();

        Node tempA = headA;

        while(tempA != null) {
            set.add(tempA);
            tempA = tempA.next;
        }

        Node tempB = headB;

        while(tempB != null) {
            if(set.contains(tempB)) return tempB;
            tempB = tempB.next;
        }

        return null;
    }
}