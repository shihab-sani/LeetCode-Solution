import java.util.Stack;
class Min_Stack {

    Stack<Integer> stack;
    Stack<Integer> min;

    public Min_Stack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()){
            stack.push(val);
            min.push(val);
        }
        else{
            stack.push(val);
            if (val>min.peek()){
                min.push(min.peek());
            }
            else
                min.push(val);
        }
    }
    
    public void pop() {
        min.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */