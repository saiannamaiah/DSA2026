import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value){
        var index = hash(key);
        if(entries[index] == null){
            entries[index] = new LinkedList<>();
        }
        for(var entry : entries[index]){
            if(entry.key ==  key){
                entry.value = value;
                return;
            }
        }
        entries[index].addLast(new Entry(key,value));
    }

    public String get(int key){
        var index = hash(key);
        var arrayBucket = entries[index];
        if(arrayBucket != null){
            for(var entry : arrayBucket){
                if(entry.key == key){
                    return entry.value;
                }
            }
        }
    return null;
    }

    public void remove(int key){
    var index = hash(key);
    var arrayBucket = entries[index];

    if (arrayBucket == null){
        throw new IllegalStateException();
    }
    for (var entry : arrayBucket){
        if (entry.key == key){
            arrayBucket.remove(entry);
            return;
        }
    }
    throw new IllegalStateException();
    }

    private int hash(int key){
        var data = Math.abs(key);
        return data % entries.length;
    }
}
