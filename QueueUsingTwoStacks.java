import java.io.*;
import java.util.*;
public class QueueUsingTwoStacks {
    public static Stack<Integer> s1 = new Stack<>();
    public static Stack<Integer> s2 = new Stack<>();
    
    public static void push_ele(int num){
        // push
        s1.push(num);
    }
    
    public static void pop_ele(){
        // pop
        
        if(!s2.empty()){
            s2.pop();
            return ;
        }
        
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        s2.pop();
    }
    
    public static int peek_ele(){
        // peek
        
        if(!s2.empty()){
            return s2.peek();
        }
        
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        QueueUsingTwoStacks q = new QueueUsingTwoStacks();
        
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            if(a==1){
                int num = sc.nextInt();
                q.push_ele(num);
            }
            else if(a==2){
                q.pop_ele();
            }
            else if(a==3){
                System.out.println(q.peek_ele());
            }
        }
        
    }
}