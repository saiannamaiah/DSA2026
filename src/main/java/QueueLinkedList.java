
public class QueueLinkedList {
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void enQueue(int value){
        var node = new Node(value);
        if(first == null){
           first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public int deQueue(){
        if (first ==null){
            throw new IllegalStateException();
        } else if (first == last) {
            var a = first.value;
            first = last = null;
            return a;
        } else {
            var second = first.next;
          first.next = null;
          first =second;
          return second.value;
        }

    }


}
