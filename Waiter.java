import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Waiter {
    public static int getNextPrime(int num){
        while(true){
            num++;
            int flag = 0;
            for(int i=2;i<=Math.sqrt(num);i++){
                if(num%i==0){
                    flag = 1;
                    break;
                }
            }
            if(flag==0) return num;
        }
     }
     
     public static void addInList(List<Integer> ans, Stack<Integer> a){
        while(!a.isEmpty()){
            ans.add(a.pop());
        }
     }

    public static List<Integer> waiter(List<Integer> number, int q) {
    // Write your code here
    List<Integer> ans = new ArrayList<>();
    int n = number.size();
    
    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();
    
    Stack<Integer> st = new Stack<>();
    for(int i:number) st.push(i);
    
    int prime = 2;
    int cnt = 1;
    while(!st.isEmpty() && cnt<=q){
        // Collections.reverse(number);
        while(!st.isEmpty()){
            int num = st.pop();
            if(num%prime==0){
                a.push(num);
            }
            else{
                b.push(num);
            }
        }
        
        addInList(ans,a);
        
        st = b;
        b = new Stack<>();
        
        prime = getNextPrime(prime);
        cnt++;
    }
    
    if(ans.size()<number.size()){
        addInList(ans, st);
    }
    
    return ans;

    }
}
