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
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static void reverse(List<Integer> arr, int start, int end){
        while(start<end){
            int temp = arr.get(start);
            arr.set(start,arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    // Write your code here
    int n = arr.size();
    d%=n;
    
    // GIVING TLE
    // T.C. O(N*D) || S.C. O(1)
    // for(int i=0;i<d;i++){
    //     for(int j=0;j<n-1;j++){
    //         int temp = arr.get(j);
    //         arr.set(j,arr.get(j+1));
    //         arr.set(j+1, temp);
    //     }
    // }
    
    
    // OPTIMIZED T.C. O(N) || S.C. O(N)
    // List<Integer> ans = new ArrayList<>();
    // for(int i=d;i<n;i++) ans.add(arr.get(i));
    // for(int i=0;i<d;i++) ans.add(arr.get(i));
    
    // OPTIMIZED T.C. O(N) || S.C. O(1)
    reverse(arr, 0, d-1);
    reverse(arr, d, n-1);
    reverse(arr, 0, n-1);
    
    return arr;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.rotateLeft(d, arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
