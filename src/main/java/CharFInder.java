import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFInder {

    public char firstNonRepeatedFinder(String value){
        Map<Character,Integer> map = new HashMap<>();

        for(var ch : value.toCharArray()){
//            if(map.containsKey(ch)){
//               var count = map.get(ch);
//               map.put(ch,count + 1);
//            } else {
//                map.put(ch,1);
//            }

            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch , count + 1);
        }
        for (var ch : value.toCharArray()){
            if(map.get(ch) == 1){
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }

    public char findFirstRepeated(String str){

        Set<Character> set = new HashSet<>();

        for (var ch : str.toCharArray()){
            if(set.contains(ch)) return ch;

            set.add(ch);
        }

        return Character.MIN_VALUE;
    }
}
