import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MinMaxRiddle {

    public static long maxSlidingWindow(long[] nums, int k) {
        int n = nums.length;
        long[] res = new long[n-k+1];
        long max = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        int num = 0;
        for(int i=0;i<n;i++){

            while(!dq.isEmpty() && dq.peek() < i-k+1){
                dq.poll();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] > nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i >= k-1){
                res[num++] = nums[dq.peek()];
                max = Math.max(res[num-1],max);
            }
        }
        return max;
    }
    
    public static int[] rightMin(long[] h){
        int n = h.length;
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n);
        
        for(int i=n-1;i>=0;i--){
            while(st.peek()!=(n) && h[st.peek()]>=h[i]){
                st.pop();
            }
            right[i] = st.peek();
            st.push(i);
        }
        return right;
    }
    public static int[] leftMin(long[] h){
        int n = h.length;
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        for(int i=0;i<n;i++){
            while(st.peek()!=-1 && h[st.peek()]>=h[i]){
                st.pop();
            }
            left[i] = st.peek();
            st.push(i);
        }
        return left;
    }
    
    static long[] riddle(long[] arr) {
        // int n = arr.length;
        
        // long[] ans = new long[n];
        
        // for(int i=0;i<n;i++){
        //     ans[i] = maxSlidingWindow(arr,i+1);
        // }
        // return ans;
        
        int n = arr.length;
        
        long[] ans = new long[n];
        
        int[] left = leftMin(arr);
        int[] right = rightMin(arr);
        
        for(int i=0;i<n;i++){
            int num = right[i]-left[i]-1;
            ans[num-1] = Math.max(ans[num-1],arr[i]);
        }
        
        for(int i=n-2;i>=0;i--){
            ans[i] = Math.max(ans[i],ans[i+1]);
        }
        return ans;
    }
    
}
