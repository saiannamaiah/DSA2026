import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

        private Node first;
        private Node last;
        private int size;

        public void AddLast(int value){
            var node = new Node(value);

            if(first == null){
                first = last = node;
            } else {
                last.next = node;
                last = node;
            }
            size++;
        }

        public void addFirst(int item){
            var node = new Node(item);
            if(first == null){
                first = last = node;
            } else {
                node.next = first;
                first = node;
            }
            size++;
        }

        public int indexOf(int item){
            var index = 0;
            var current = first;

            while(current != null){
                if(current.value == item){
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }

        public boolean contains(int item){
            return indexOf(item) != -1;
        }

        public void removeFirst(){
            if(first == null)
                throw new IllegalArgumentException();
            else if (first == last) {
                first = last = null;
                return;
            } else {
               var second = first.next;
               first.next = null;
               first = second;
            }
            size--;
        }

        public void removeLast(){
            if(first == null){
                throw new NoSuchElementException();
            } else if(first == last){
                first = last = null;
            } else {
            var current = first;
            while(current != null){
                if(current.next == last)
                    break;
                current = current.next;
            }
                last = current;
                last.next = null;
            }
            size--;
        }

        public int size(){
            return size;
        }

        public int[] toArray(){
            int[] array = new int[size];
            var current = first;
            var index = 0;
            while (current != null){
                array[index++] = current.value;
                current = current.next;
            }
        return array;
        }

        public void reverse(){
            if(first == null)
                return;
            var previous = first;
            var current = first.next;

            while(current != null){
                var forward = current.next;
                current.next = previous;
                previous = current;
                current = forward;
            }
            last = first;
            last.next = null;
            first = previous;
        }

        public int kthNode(int value){
            var current = first;
            var a = first;
            var b = first;
            for(int i = 0; i<value - 1; i++){
                b = b.next;
            }

            while (b.next != null){
                a = a.next;
                b = b.next;
            }
            return a.value;
        }

        public void pritnMiddle(){
            var a = first;
            var b = first;
            var pre = first;

            while(b != null && b.next != null){
                pre = a;
                a = a.next;
                b = b.next.next;
            }

            if(b == null){
                System.out.println(pre.value + "even" + a.value);
            }else {
                System.out.println("odd" + a.value);
            }

        }

}
