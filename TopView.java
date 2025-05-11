import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.w3c.dom.Node;

public class TopView {
    static class Pair<T,E>{
        T node;
        E height;
        
        public Pair(T node, E height){
            this.node = node;
            this.height = height;
        }
    }
    
	public static void topView(Node root) {
      
      Queue<Pair<Node,Integer>> q = new LinkedList<>();
      q.offer(new Pair<>(root,0));
      
      Map<Integer,Integer> map = new TreeMap<>();
      
      while(!q.isEmpty()){
        
        Pair<Node,Integer> front = q.poll();
        
        if(!map.containsKey(front.height)){
            map.put(front.height, front.node.data);
        }
        
        if(front.node.left!=null){
            q.offer(new Pair<Node,Integer>(front.node.left, front.height-1));
        }
        if(front.node.right!=null){
            q.offer(new Pair<Node,Integer>(front.node.right, front.height+1));
        }
      }
      
      for(Integer i:map.keySet()){
        System.out.print(map.get(i) + " ");
      }
      
    }
}
