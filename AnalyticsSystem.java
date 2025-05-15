import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

enum FEATURE{
    feature1,feature2,feature3;
}

class AnalyticsStore{
    public List<FEATURE> analyticStoreList;

    public AnalyticsStore(){
        this.analyticStoreList = new ArrayList<>();
    }

}


public class AnalyticsSystem {
    int k;
    Queue<FEATURE> frequentFeature = new LinkedList<>();
    AnalyticsStore analyticsStore;

    public AnalyticsSystem(int k){
        this.k = k;
        this.analyticsStore = new AnalyticsStore();
    }

    public void registerAction(FEATURE feature){
        frequentFeature.offer(feature);
        if(frequentFeature.size()==k){
            this.analyticsStore.analyticStoreList.add(frequentFeature.poll());
        }
    }

    public int getTotalNumberOfLoggedActions(){
        return this.analyticsStore.analyticStoreList.size();
    }

    public int getTotalNumberOfLoggedActionsButNotSentToTheAnalyticsStore(){
        return this.frequentFeature.size();
    }

    public List<FEATURE> getMostFrequentlyUsedActions(){
        if(analyticsStore.analyticStoreList.isEmpty()) return new ArrayList<>();
        List<FEATURE> list = new ArrayList<>();
        int n = analyticsStore.analyticStoreList.size();
        while(n-->0){
            list.add(frequentFeature.peek());
            frequentFeature.offer(frequentFeature.poll());
        }
        return list;
    }
}
