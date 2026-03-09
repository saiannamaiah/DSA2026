import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args){
//        var list = new LinkedList();
//        list.addFirst(10);
//        list.addFirst(20);
//        list.addFirst(30);
//        list.addFirst(40);
//        list.addFirst(50);
//        System.out.println(Arrays.toString(list.toArray()));
//        list.pritnMiddle();

        CharFInder charfiner = new CharFInder();
        charfiner.firstNonRepeatedFinder("a green apple");
    }

    public static void QueueReverser(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }
}
