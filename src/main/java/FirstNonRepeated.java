import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeated {
    public char FirstNonRepeated(String value){
        Map<Character, Integer> map = new HashMap<>();
        for(var ch : value.toCharArray()){
//            if (map.containsKey(ch)) {
//
//                var count = map.get(ch);
//                map.put(ch,count+1);
//            } else{
//                map.put(ch,1);
//            }

            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch,count + 1);
        }

        for (var ch : value.toCharArray()){
            if(map.get(ch) == 1){
                return ch;
            }
        }

        return Character.MIN_VALUE;
    }

    public char findFirtNonUnique(String value){
        Set<Character> mapSet = new HashSet<>();

        for (var ch : value.toCharArray()){
            if(mapSet.contains(ch)){
                return ch;
            }
            mapSet.add(ch);
        }
        return Character.MIN_VALUE;
    }

    public int findMostRepeatedNumber(int[] numbers){
        Map<Integer,Integer> map = new HashMap<>();
        for(var num : numbers){
            var count = map.containsKey(num) ? map.get(num) : 0;
            map.put(num,count + 1);
        }

        int maxCount = 0;
        int mostReaptedNumber = numbers[0];

        for (var ch : map.entrySet()){
            if(ch.getValue() > maxCount){
                maxCount = ch.getValue();
                mostReaptedNumber = ch.getKey();
            }
        }
        return mostReaptedNumber;
    }

    public int countPairWithDifference(int[] numbers, int k){
        Set<Integer> set = new HashSet<>();
        for(var num : numbers){
            set.add(num);
        }

        var count = 0;

        for(var num : set){
            if(set.contains(num + k)){
                count++;
            }
        }

        return count;
    }
}
