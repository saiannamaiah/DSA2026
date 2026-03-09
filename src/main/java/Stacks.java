import java.util.Arrays;

public class Stacks {

    private int[] items = new int[5];
    private int counter;

    public void push(int value){
        if(counter == items.length){
            throw new StackOverflowError();
        }
        items[counter++] = value;
    }

    public int pop(){
        if(counter == 0){
            throw new IllegalStateException();
        }
        return items[--counter];
    }

    public int peek(){
        return items[counter - 1];
    }

    @Override
    public String toString(){
        var content = Arrays.copyOfRange(items , 0 , counter);
        return Arrays.toString(content);
    }
}
