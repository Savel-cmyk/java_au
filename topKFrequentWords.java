import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
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
        return Arrays.stream(words)
                     .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                     .entrySet()
                     .stream()
                     .sorted(Map.Entry.<String,Long>comparingByValue().reversed().thenComparing(Map.Entry.<String,Long>comparingByKey()))
                     .map(Map.Entry::<String,Long>getKey)
                     .limit(k)
                     .collect(Collectors.toList());
    }
}
