package design;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class MinStack {

    class MinStackItem{
        private int value;
        private int minValue;

        public int getValue(){
            return value;
        }

        public int getMinValue(){
            return minValue;
        }

        public MinStackItem(int value, int minValueBelow){
            this.value = value;
            minValue = Math.min(value,minValueBelow);
        }


    }

    /** initialize your data structure here. */
    private final Deque<MinStackItem> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        int minFromBelow = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek().getMinValue();
        stack.push(new MinStackItem(val,minFromBelow));

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.pop().getValue();

    }

    public int getMin() {
        assert stack.peek() != null;
        return stack.peek().getMinValue();

    }
}
