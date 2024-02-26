package coding.livecode25_07;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        System.out.println("isAnagram(\"anagram\",\"nagaram\") = " + isAnagram("a", "ab"));
        /**
         * Input: nums = [1,2,3,1,1,3]
         * Output: 4
         *
         *
         * Пара (i, j) называется хорошей, если nums[i] == nums[j] и i < j.
         * Подсчитайте, сколько раз встречается каждое число.
         * Если число встречается n раз, то из этого числа можно составить n * (n – 1) // 2 хороших пары.
         */
        int[] nums = new int[]{1, 1, 1, 1};
        System.out.println("numIdenticalPairs() = " + numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
//        int count = 0;
//        Map<Integer, Long> collect = Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//        for (Map.Entry<Integer, Long> elem : collect.entrySet()) {
//            Long value = elem.getValue();
//            int i = Math.toIntExact(count + (value * (value - 1)) / 2);
//            count = count + i;
//        }
//        return count;

        return Math.toIntExact(Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .map(aLong -> aLong * (aLong - 1) / 2)
                .reduce(Long::sum).get());

//        return Math.toIntExact(collect.values().stream()
//                .map(aLong -> aLong * (aLong - 1) / 2)
//                .reduce(Long::sum).get());
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int found = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (found == nums[j]) {
//                    count++;
//                }
//            }
//        }
//        return count;
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        char[] characterS = s.toCharArray();
        char[] charactert = t.toCharArray();
        Arrays.sort(characterS);
        Arrays.sort(charactert);

        return Arrays.equals(characterS, charactert);
    }
}
