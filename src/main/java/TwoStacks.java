public class TwoStacks {

    private int [] items;
    private int top1;
    private int top2;
private int size;
    public TwoStacks(int size){
        size = size;
        items = new int[size];
        top1 = -1;
        top2 = size;
    }

    public void push1(int value){
        items[++top1] = value;
    }

    public void push2(int value){
        items[--top2] = value;
    }

    public int pop1(){
       return items[top1--];
    }

    public int pop2(){
        return items[top2++];
    }

    public boolean isEmpty1(){
        return top1 == -1;
    }
    public boolean isEmpty2(){
        return top2 == size;
    }

}
