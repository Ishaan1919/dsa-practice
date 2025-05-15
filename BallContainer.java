public class BallContainer {
    public static String organizingContainers(List<List<Integer>> mat) {
    // Write your code here
    int n = mat.size();
    
    List<Integer> colors = new ArrayList<>();
    List<Integer> capi = new ArrayList<>();
    
    for(int i=0;i<n;i++){
        int color = 0;
        int cap = 0;
        for(int j=0;j<n;j++){
            color+=mat.get(j).get(i);
            cap+=mat.get(i).get(j);
        }
        colors.add(color);
        capi.add(cap);
    }
    
    Collections.sort(colors);
    Collections.sort(capi); 
    
    for(int i=0;i<n;i++){
        if((int)colors.get(i)!=(int)capi.get(i)){
            return "Impossible";
        }
    }
    
    return "Possible";

    }

}
