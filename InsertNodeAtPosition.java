public class InsertNodeAtPosition {
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode list, int data, int position) {
        // Write your code here
            SinglyLinkedListNode prev = null;
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        SinglyLinkedListNode head = list;
        while(list!=null && position>0){
            prev = list;
            list = list.next;
            position--;
        }
        
        if(list==null){
            prev.next = node;
            return head;
        }
        
        prev.next = node;
        node.next = list;
        
        return head;
    
    
    
    }
}
