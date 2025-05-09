import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        int sum = 0;
        
        int n = h1.size();
        for(int i=n-1;i>=0;i--){
            sum += h1.get(i);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        
        sum = 0;
        n = h2.size();
        for(int i=n-1;i>=0;i--){
            sum += h2.get(i);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        
        sum = 0;
        
        int max = 0;
        n = h3.size();
        for(int i=n-1;i>=0;i--){
            sum += h3.get(i);
            map.put(sum, map.getOrDefault(sum, 0)+1);
            if(map.get(sum)==3){
                max = sum;
            }
        }
        
        return max;

    }
}
