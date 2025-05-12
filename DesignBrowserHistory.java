public class DesignParkingSystem{
    class BrowserHistory {
        Stack<String> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();
        public BrowserHistory(String homepage) {
            st1.push(homepage);
        }
        
        public void visit(String url) {
            st1.push(url);
            st2 = new Stack<>();
        }
        
        public String back(int steps) {
            while(st1.size()>1 && steps-->0){
                st2.push(st1.pop());
            }
            return st1.peek();
        }
        
        public String forward(int steps) {
            while(!st2.isEmpty() && steps-->0){
                st1.push(st2.pop());
            }
            return st1.peek();
        }
    }
}