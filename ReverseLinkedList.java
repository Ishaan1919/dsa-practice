public class ReverseLinkedList {
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode list) {
    
        if(list==null) return list;
        
        SinglyLinkedListNode curr = list;
        SinglyLinkedListNode prev = null;
        
        while(curr!=null){
            SinglyLinkedListNode node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }
        return prev;
    }
}
