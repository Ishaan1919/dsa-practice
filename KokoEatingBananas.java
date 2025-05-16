public class KokoEatingBananas {
    public int hoursTaken(int[] piles, int num){
        int h = 0;
        int n = piles.length;
        for(int i=0;i<n;i++){
            h += (piles[i]/num);
            if(piles[i]%num!=0) h++;
        }
        System.out.println(h + " " + num);
        return h;

    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = piles[0];
        for(int i=1;i<n;i++){
            max = Math.max(max,piles[i]);
        }

        int s = 1;
        int e = max;

        while(s<e){
            int mid = (s+e)/2;

            if(hoursTaken(piles,mid)<=h){
                e = mid;
            }
            else{
                s = mid+1;
            }
        }
        System.out.print(s + " " + e);
        return s;
    }
}
