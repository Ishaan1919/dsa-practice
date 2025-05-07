import java.util.Scanner;
import java.util.Set;

public class HashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        sc.nextLine();
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            if(!line.equals(""))
            set.add(line);
            System.out.println(set.size());
        }
    }
}
