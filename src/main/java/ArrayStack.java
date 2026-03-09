import java.util.Stack;

public class ArrayStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void addQueue(int value){

        stack1.push(value);
    }

    public int deQueue(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.empty()){
            throw new RuntimeException();
        }
        return stack2.pop();
    }
}
