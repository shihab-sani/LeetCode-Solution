import java.util.ArrayList;

class BrowserHistory {
    int index;
    int length;
    ArrayList<String> history;

    public BrowserHistory(String homepage) {
        this.index = 0;
        this.length = 1;
        this.history = new ArrayList<>();
        this.history.add(homepage);
    }
    
    public void visit(String url) {
        if (history.size() < (index+2)) {
            history.add(url);
        } else {
            history.set(index+1, url);
        }
        index++;
        length = index+1;
    }
    
    public String back(int steps) {
        if ((index-steps) > 0) {
            index -= steps;
            return history.get(index);
        } else {
            index = 0;
            return history.get(0);
        }
    }
    
    public String forward(int steps) {
        if ((index+steps) < length) {
            index += steps;
            return history.get(index);
        } else {
            index = length-1;
            return history.get(length-1);
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */