public class PriorityQueue {
    private int[] items;
    private int rear = -1;
    private int front;

    public PriorityQueue(int size){
        items = new int[size];
    }

    public void addItems(int value){
        if(rear == items.length){
            throw new IllegalStateException();
        }

        if(rear == -1){
            items[++rear] = value;

        } else {
            int i;
             for(i = rear; i >= 0; i--){
                 if(items[i] > value){
                     items[i + 1] = items[i];
                 } else {

                     break;
                 }
             }
            items[i + 1] = value;
            rear++;
        }
    }

    public int remove(){
        return items[--rear];
    }

}
