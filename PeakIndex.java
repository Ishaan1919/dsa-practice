public class PeakIndex{
    public int solve(int[] arr, int s, int e, int n){
        if(s>e) return s;
        int mid = (s+e)/2;
        if(mid-1>=0 && mid+1<n && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
        else if(mid-1>=0 && arr[mid-1]<arr[mid]){
            return solve(arr,mid+1,e,n);
        }
        else{
            return solve(arr,s,mid,n);
        }
    }

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        // return solve(arr,0,n-1,n);
        int s = 0;
        int e = n-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(mid-1>=0 && mid+1<n && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
            else if(mid-1>=0 && arr[mid-1]<arr[mid]){
                s = mid+1;
            }
            else{
                e = mid;
            }
        }
        return s;
    }
}