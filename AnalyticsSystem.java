import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

enum FEATURE{
    feature1,feature2,feature3;
}


public class AnalyticsSystem {
    int k;
    List<FEATURE> analyticStore;
    Queue<FEATURE> frequentFeature = new LinkedList<>();

    public AnalyticsSystem(int k){
        this.k = k;
        this.analyticStore = new ArrayList<>();
    }

    public void registerAction(FEATURE feature){
        frequentFeature.offer(feature);
        if(frequentFeature.size()==k){
            analyticStore.add(frequentFeature.poll());
        }
    }

    public int getTotalNumberOfLoggedActions(){
        return this.analyticStore.size();
    }

    public int getTotalNumberOfLoggedActionsButNotSentToTheAnalyticsStore(){
        return this.frequentFeature.size();
    }

    public List<FEATURE> getMostFrequentlyUsedActions(){
        if(analyticStore.isEmpty()) return new ArrayList<>();
        List<FEATURE> list = new ArrayList<>();
        int n = analyticStore.size();
        while(n-->0){
            list.add(frequentFeature.peek());
            frequentFeature.offer(frequentFeature.poll());
        }
        return list;
    }
}
