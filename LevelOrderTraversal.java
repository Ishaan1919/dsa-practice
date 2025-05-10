import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class LevelOrderTraversal {
    public static void levelOrder(Node root) {
      
      Queue<Node> q = new LinkedList<>();
      q.offer(root);
      
      while(!q.isEmpty()){
        Node front = q.poll();
        System.out.print(front.data + " ");
        if(front.left!=null) q.offer(front.left);
        if(front.right!=null) q.offer(front.right);
      }
      
    }
}
