public class DownToZero{
    public static int factor(int n){
        for(int i=(int)Math.sqrt(n);i>=2;i--){
            if(n%i==0){
                return Math.max(n/i,i);
            }
        }
        return n-1;
    }

    public static int downToZero(int n) {
        // if (n <= 3) return n;

        Queue<int[]> q = new LinkedList<>();
        Set<Integer> s = new HashSet<>();
        q.offer(new int[]{n,0});
        s.add(n);
        while(!q.isEmpty()){
            int[] front = q.poll();
            int num = front[0];
            int moves = front[1];
            if(front[0]==0) return front[1];
            
            // condition 1
            if(!s.contains(num-1)){
                q.offer(new int[]{num-1,moves+1});
                s.add(num-1);
            }
            
            // condition 2
            
            for(int i=(int)Math.sqrt(n);i>=2;i--){
            if(num%i==0){
                int fact = Math.max(num/i,i);
                if(!s.contains(fact)){
                    q.offer(new int[]{fact,moves+1});
                    s.add(fact);
                }
            }
        }
            // int fact = factor(num);
            
        }
        return -1;
    }

}