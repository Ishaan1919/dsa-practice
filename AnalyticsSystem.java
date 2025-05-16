import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


enum ActionEnum{
    feature1,feature2,feature3;
}

class AnalyticsStore{
    public List<ActionEnum> analyticStoreList;

    public AnalyticsStore(){
        this.analyticStoreList = new ArrayList<>();
    }

    public void storeActions(Queue<ActionEnum> frequentActionEnum){
        while(!frequentActionEnum.isEmpty()){
                this.analyticStoreList.add(frequentActionEnum.poll());
            }
    }

}


public class AnalyticsSystem {
    public static void main(String[] args) {
        for(ActionEnum i:ActionEnum.values()){
            System.out.println(i.name());
        }
    }


    int k;
    Queue<ActionEnum> frequentActionEnum = new LinkedList<>();
    AnalyticsStore analyticsStore;

    public AnalyticsSystem(int k){
        this.k = k;
        this.analyticsStore = new AnalyticsStore();
    }

    public void registerAction(ActionEnum ActionEnum){
        frequentActionEnum.offer(ActionEnum);
        if(frequentActionEnum.size()==k){
            analyticsStore.storeActions(frequentActionEnum);
        }
    }

    public int getTotalNumberOfLoggedActions(){
        return this.analyticsStore.analyticStoreList.size();
    }

    public int getTotalNumberOfLoggedActionsButNotSentToTheAnalyticsStore(){
        return this.frequentActionEnum.size();
    }

    public List<ActionEnum> getMostFrequentlyUsedActions(){

        if(analyticsStore.analyticStoreList.isEmpty()) return new ArrayList<>();
        List<ActionEnum> store = analyticsStore.analyticStoreList;
        int n = store.size();

        List<ActionEnum> maxFreq = new ArrayList<>();
        int max = 0;
        for(ActionEnum i:ActionEnum.values()){

            int freq = 0;
            for(ActionEnum a:store){
                if(i==a){
                    freq++;
                }
            }
            if(freq>max){
                max = freq;
                maxFreq = new ArrayList<>();
                maxFreq.add(i);
            }
            else if(freq==max){
                maxFreq.add(i);
            }
        }

        maxFreq.sort((one , two) -> {
            return one.name().compareTo(two.name());
        });

        return maxFreq;

        // if(analyticsStore.analyticStoreList.isEmpty()) return new ArrayList<>();
        // List<ActionEnum> list = new ArrayList<>();
        // int n = analyticsStore.analyticStoreList.size();
        // while(n-->0){
        //     list.add(frequentActionEnum.peek());
        //     frequentActionEnum.offer(frequentActionEnum.poll());
        // }
        // return list;
    }
}
