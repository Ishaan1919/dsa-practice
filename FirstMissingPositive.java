public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int one = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==1) one++;
            else if(nums[i]<=0 || nums[i]>n) nums[i] = 1;
        }

        if(one==0) return 1;

        for(int i=0;i<n;i++){
            int num = Math.abs(nums[i]);
            if(nums[num-1]>0) nums[num-1]*=-1;
        }

        for(int i=0;i<n;i++){
            if(nums[i]>=0) return i+1;
        }
        return n+1;
    }
}
