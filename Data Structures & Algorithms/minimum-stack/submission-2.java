class MinStack {

    private Deque<Integer> mainStack;
    private Deque<Integer> minStack;

    public MinStack() { 
        mainStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        mainStack.push(val);

        if(minStack.isEmpty()) {
            minStack.push(val);
        }
        else {
            int currentMin = minStack.peek();
            minStack.push(Math.min(val,currentMin));
        }
    }
    
    public void pop() {
        mainStack.pop();
        minStack.pop();
    }
    
    public int top() {
         return mainStack.peek();     
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
