import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class topKFrequentWords {
    public static void main(String[] args) {

        String[] test_1 = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(Arrays.toString(test_1));
        System.out.println(topKFrequent(test_1, 2));

        String[] test_2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(Arrays.toString(test_2));
        System.out.println(topKFrequent(test_2, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map.entrySet().stream()
                .sorted((e1, e2) -> {
                    if (e1.getValue() == e2.getValue()) {
                        return e1.getKey().compareTo(e2.getKey());
                    } else {
                        return e2.getValue() - e1.getValue();
                    }

                })
                .limit(k)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
