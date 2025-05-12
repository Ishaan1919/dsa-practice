import org.w3c.dom.Node;

public class TreeHuffmanDecoding {
    void decode(String s, Node root) {
        // System.out.println(s);
       Node temp = root;
       int n = s.length();
       for(int i=0;i<n;i++){
        char c = s.charAt(i);
        if(c=='0'){
            temp = temp.left;
        }
        else{
            temp = temp.right;
        }
        // System.out.println(c + " " + temp.data);
        if(temp.left==null && temp.right==null){
            System.out.print(temp.data);
            temp = root;
        }
       }
    }
}
