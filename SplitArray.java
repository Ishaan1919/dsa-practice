public class SplitArray {
    public boolean split(int[] nums, int mid, int k){
        int n = nums.length;
        int cnt = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            if(sum+nums[i] > mid){
                sum = nums[i];
                cnt++;
            }
            else{
                sum += nums[i];
            }
            if(cnt>=k) return false;
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            sum += nums[i];
        }

        int s = max;
        int e = sum;

        while(s<=e){
            int mid = (s+e)/2;
            if(split(nums,mid,k)){
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return s;

    }
}
