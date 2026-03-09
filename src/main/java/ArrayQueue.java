import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int front;
    private  int rear;
    private int counter;

    public ArrayQueue(int size){
        items = new  int[size];
    }

   public void addItems (int value){
        if(items.length == counter){
            throw new IllegalStateException();
        }
       items[rear] = value;
        rear = (rear + 1) % items.length;
       counter++;
   }

    public int removeItems(){
      var item = items[front];
      items[front] = 0;
      front = (front + 1) % items.length;
      counter--;
      return item;

    }

    @Override
    public String toString(){
       return Arrays.toString(items);
    }


}
