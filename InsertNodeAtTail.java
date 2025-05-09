public class InsertNodeAtTail {
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        if(head==null) return node;
        SinglyLinkedListNode ans = head;
        while(head.next!=null) head = head.next;
        head.next = node;
        return ans;
    }
}
