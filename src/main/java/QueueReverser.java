import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

    public void reverse(Queue<Integer> queue, int k){

        if(queue == null || k < 0 || k > queue.size() ){
            throw new IllegalStateException();
        }

        Stack<Integer> stacks = new Stack<>();

        for(int i =0 ; i < k; i++){
            stacks.push(queue.remove());
        }

        while (!stacks.empty()){
            queue.add(stacks.pop());
        }

        int remaining = queue.size() - k;

        for (int i = 0; i < remaining ; i++){
            queue.add(queue.remove());
        }
    }

}
