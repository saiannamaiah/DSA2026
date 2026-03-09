public class Arrays {
    private int[] items;
    private int size = 0;

    public Arrays(int size){
        items = new int[size];
    }

    public void Insert(int value){
        if(size == items.length){
            var newItems = new int[size * 2];
            for (int i = 0; i < size; i++){
                newItems[i] = items[i];
            }

            items = newItems;
        }
        items[size++] = value;
    }

    public void removeAt(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException();

        if(index == size - 1){
            items[--size] = 0;
            return;
        } else {
            for (int i = index; i < size; i++){
                items[i] = items[i + 1];
            }
            size--;
        }

    }

    public int indexOff(int value){
        for(int i = 0; i < size; i++){
            if(items[i] == value){
                return i;
            }
        }
        return -1;
    }

    public void print(){
        for (int i = 0; i < size; i++){
            System.out.println(items[i]);
        }
    }
}
