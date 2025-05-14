import java.util.Stack;

public class TwoCharacters {
    public static int alternate(String s) {
        
        int n = s.length();
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                char c1 = s.charAt(i);
                char c2 = s.charAt(j);
                boolean flag = true;
                Stack<Character> st = new Stack<>();
                for(int k=0;k<n;k++){
                    char c = s.charAt(k);
                    if(st.isEmpty() && (c==c1 || c==c2)){
                        st.push(c);
                    }
                    else if(c==c1){
                        if(st.peek()==c1){
                            flag = false;
                            break;
                        }
                        st.push(c);
                    }
                    else if(c==c2){
                        if(st.peek()==c2){
                            flag = false;
                            break;
                        }
                        st.push(c);
                    }
                }
                if(flag){
                    max = Math.max(max,st.size());
                }
            }
        }
        
        return max;    

    }
}
