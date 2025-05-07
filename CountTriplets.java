import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {
    
    public static void main(String[] args) {
        
    }

    static long countTriplets(List<Long> arr, long r) {
        Map<Long,Long> right = new HashMap<>();
        Map<Long,Long> left = new HashMap<>();
        
        long ans = (long)0;
        
        for(Long i:arr){
            right.put(i, right.getOrDefault(i, (long)0)+(long)1);
        }
        // if(r==1){
        //     for(Long i:right.keySet()){
        //         Long num = right.get(i);
        //         // System.out.println(num);
        //         if(num>=3)
        //         for(Long a=num-2;a>=1;a--){
        //             Long sum = (a*(a+1))/2;
        //             // System.out.println(sum);
        //             ans += sum;
        //         }
        //     }
        //     return ans;
        //     }
        
        for(Long i:arr){
            right.put(i, right.getOrDefault(i, (long)0) - 1);
            
            long a = i/r;
            long b = i;
            long c = i*r;
            
            if(right.containsKey(c) && i%r==0 && left.containsKey(a)){
                System.out.print(i);
                ans += right.get(c)*left.get(a);
                // ans += left.get(a);
            }
            
            left.put(i, left.getOrDefault(i, (long)0) + 1);
        }
        
        return ans;
        
        
        // for(Long i:arr){
        //     map.put(i, map.getOrDefault(i, (long)0)+(long)1);
        // }
        
        // Long ans = (long)0;
        // int n = arr.size();
        // for(Long i:map.keySet()){
            
        //     if(r==1){
        //         Long num = map.get(i);
        //         // System.out.println(num);
        //         if(num>=3)
        //         for(Long a=num-2;a>=1;a--){
        //             Long sum = (a*(a+1))/2;
        //             // System.out.println(sum);
        //             ans += sum;
        //         }
        //         continue;
                
        //     }
            
            
        //     Long a = i;
        //     Long cnt = map.get(i);
        //     Long b = a*r;
            
        //     if(map.containsKey(b)){
        //         cnt *= map.get(b);
        //         Long c = b*r;
                
        //         if(map.containsKey(c)){
        //             cnt *= map.get(c);
        //             ans += cnt;
        //         }
        //     }
        // }
        // // System.out.println("Hello");
        // // System.out.println(ans);
        
        // return ans;

    }
}
