import java.util.List;
import java.util.Stack;

public class PoisnousPlants {
    public static int poisonousPlants(List<Integer> p) {
    // Write your code here
    // List<Integer> list = p;
    // int cnt = 0;
    // while(true){
    //     cnt++;
    //     int n = list.size();
    //     List<Integer> temp = new ArrayList<>();
    //     temp.add(list.get(0));
    //     for(int i=1;i<n;i++){
    //         if(list.get(i)<=list.get(i-1)){
    //             temp.add(list.get(i));
    //         }
    //     }
    //     if(list.size()==temp.size()) return cnt-1;
    //     else{
    //         list = temp;
    //     }
    // }
    // 
    // return cnt;
    
    Stack<Integer> st = new Stack<>();
    int n = p.size();
    st.push(-1);
    int cnt = 0;
    int max = 0;
    for(int i=0;i<n;i++){
        while(st.peek()!=-1 && p.get(st.peek())>=p.get(i)){
            st.pop();
        }
        if(st.peek()==-1){
            max = Math.max(max,i);
        }
        else{
            max = Math.max(max,i-st.peek());
        }
        st.push(i);
    }
    return max;
    
    

    }
}
