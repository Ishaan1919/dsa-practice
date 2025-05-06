import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> q) {
        
        
        // TLE  T.C. O(N*Q)  ||  S.C. O(N+1)
        
        // long[] arr = new long[n+1];
        // int size = q.size();
        // long max = 0;
        // for(int i=0;i<size;i++){
        //     int start = q.get(i).get(0);
        //     int end = q.get(i).get(1);
        //     int k = q.get(i).get(2);
        //     for(int j=start;j<=end;j++){
        //         arr[j]+=k;
                
        //     }
        // }
        // for(int i=0;i<n+1;i++) max = Math.max(max, arr[i]);
        // return max;


        // OPTIMIZED  T.C. O(N) || S.C. O(N+2)
        int size = q.size();
        long[] arr = new long[n+2];
        long max = 0;
        for(int i=0;i<size;i++){
            int start = q.get(i).get(0);
            int end = q.get(i).get(1);
            int k = q.get(i).get(2);
            arr[start] += k;
            arr[end+1] -= k;
        }
        
        for(int i=1;i<n+2;i++){
            arr[i] = arr[i] + arr[i-1];
            max = Math.max(arr[i],max);
        }
        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
