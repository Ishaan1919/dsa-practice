import java.util.Arrays;
import java.util.Scanner;

public class MeetingIntervals {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[][] nums = new Integer[n][2];

        for(int i=0;i<n;i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        boolean ans = meetings(nums);
        System.out.println(ans);
    }

    public static boolean meetings(Integer[][] nums){

        int n = nums.length;
        Arrays.sort(nums, (one,two) -> {
            return Integer.compare(one[0],two[0]);
        });
        for(int i=1;i<n;i++){
            if(nums[i-1][1]>nums[i][0]) return false;
        }

        return true;
    }
}
