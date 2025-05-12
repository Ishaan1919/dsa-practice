class TaskManager {

    class Pair{
        int priority;
        int taskId;
        public Pair(int a, int b){
            this.priority = a;
            this.taskId = b;
        }
    }
    Map<Integer,Integer> id = new HashMap<>();
    Map<Integer,Integer> map = new HashMap<>();
    Queue<Pair> pq = new PriorityQueue<>((Pair one, Pair two) -> {
        if(one.priority == two.priority) return two.taskId - one.taskId;
        else return two.priority - one.priority;
    });

    public TaskManager(List<List<Integer>> tasks) {
        for(List<Integer> i:tasks){
            id.put(i.get(1),i.get(0));
            map.put(i.get(1),i.get(2));
            pq.offer(new Pair(i.get(2),i.get(1)));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        map.put(taskId, priority);
        pq.offer(new Pair(priority,taskId));
        id.put(taskId,userId);
    }
    
    public void edit(int taskId, int newPriority) {
        map.put(taskId,newPriority);
        pq.offer(new Pair(newPriority,taskId));
    }
    
    public void rmv(int taskId) {
        map.remove(taskId);
        id.remove(taskId);
    }
    
    public int execTop() {
        if(pq.isEmpty()) return -1;

        while(!pq.isEmpty()){
            Pair pair = pq.peek();
            if(!map.containsKey(pair.taskId) || map.get(pair.taskId)!=pair.priority){
                pq.poll();
            }
            else break ;
        }
        if(!pq.isEmpty()){
            map.remove(pq.peek().taskId);
            return id.get(pq.poll().taskId);
        }
        return -1;
    }
}
