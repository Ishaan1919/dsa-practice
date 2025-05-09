public class MergeSortedLinkedLists {
    class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        
        if(head1==null) return head2;
        
        SinglyLinkedListNode ptr1 = head1;
        SinglyLinkedListNode ptr2 = head2;
        
        SinglyLinkedListNode head = new SinglyLinkedListNode(0);
        
        while(ptr1!=null && ptr2!=null){
            if(ptr1.data <= ptr2.data){
                head.next = ptr1;
                head = head.next;
                ptr1 = ptr1.next;
                head.next = null;
            }
            else{
                head.next = ptr2;
                head = head.next;
                ptr2 = ptr2.next;
                head.next = null;
            }
        }
        
        if(ptr1!=null){
            head.next = ptr1;
        }
        if(ptr2!=null){
            head.next = ptr2;
        }
        
        if(head1.data<=head2.data) return head1;
        return head2;
        
    }
}
