import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        
    }

    public static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        
        int n = s.length();
        
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            
            if(c=='(' || c=='[' || c=='{'){
                st.push(c);
            }
            else if(!st.empty()){
                if(c==')' && st.peek()=='('){
                    st.pop();
                }
                else if(c==']' && st.peek()=='['){
                    st.pop();
                }
                else if(c=='}' && st.peek()=='{'){
                    st.pop();
                }
                else{
                    return "NO";
                }
            }
                else{
                    return "NO";
                }
        }
        if(st.size()==0) return "YES";
        return "NO";

    }
}
