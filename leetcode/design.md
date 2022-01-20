# Design

+ [Min Stack](#min-stack)
+ [Implement Stack using Queues](#implement-stack-using-queues)
+ [Implement Queue using Stacks](#implement-queue-using-stacks)

## Min Stack

https://leetcode.com/problems/min-stack/

```java
class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public void push(int val) {
        stack.push(val);
        pq.add(val);
    }
    
    public void pop() {
        pq.remove(stack.pop());
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return pq.peek();
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
 ```

## Implemet Stack using Queues

https://leetcode.com/problems/implement-stack-using-queues/

```java
class MyStack {

    private final Queue<Integer> master = new LinkedList<>();
    private Integer lastElement;

    public void push(final int x) {
        master.add(x);
        lastElement = x;
    }

    public int pop() {
        final Queue<Integer> slave = new LinkedList<>();
        while (master.size() > 1) {
            lastElement = master.remove();
            slave.add(lastElement);
        }
        final int result = master.remove();
        for (final int element:  slave) {
            master.add(element);
        }
        return result;
    }

    public int top() {
        return lastElement;
    }

    public boolean empty() {
        return master.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
 ```

## Implement Queue using Stacks

https://leetcode.com/problems/implement-queue-using-stacks/

```java
class MyQueue {
    private Stack<Integer> one;
    private Stack<Integer> two;
    public MyQueue() {
        this.one = new Stack<>();
        this.two = new Stack<>();
    }
    
    public void push(int x) {
        this.one.push(x);
    }
    
    public int pop() {
        if(this.two.isEmpty()) {
            int size = this.one.size();
            for(int i = 0; i < size; i++) {
                this.two.push(this.one.pop());
            }
            
            return this.two.pop();
        }
        else {
           return this.two.pop(); 
        }
    }
    
    public int peek() {
        if(this.two.isEmpty()) {
            if(one.isEmpty()) {
                return -1;
            }
            int size = this.one.size();
            for(int i = 0; i < size; i++) {
                this.two.push(this.one.pop());
            }
            
            return this.two.peek();
        }
        else {
            return this.two.peek();
        }
    }
    
    public boolean empty() {
        return this.two.isEmpty() && this.one.isEmpty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 ```
