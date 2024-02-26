package coding.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AlgorithmsSumTwoNumbersInArray {
    public static void main(String[] args) {
        int[] array = {100, 5, 6, 6, 9, 8};
        int result = 17;
        System.out.println("answer = " + extracted(array, result));
        System.out.println("isNumberSumOfArraysNum(array,result) = " + isNumberSumOfArraysNum(array, result));
        System.out.println("Arrays.toString(twoSumHash(array, result) = " + Arrays.toString(twoSumHash(array, result)));

    }

    public static int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int requiredNumber = target - nums[i];
            if (map.containsKey(requiredNumber) && map.get(requiredNumber) != i) {
                System.out.println("i + \":\" + map.get(requiredNumber) = " + i + ":" + map.get(requiredNumber));
                return new int[]{i, map.get(requiredNumber)};
            }
        }
        throw new IllegalArgumentException("No solution for defined input data");
    }

    public static boolean isNumberSumOfArraysNum(int[] nums, int value) {
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left < right) {
            result = nums[left] + nums[right];
            if (result == value) {
                return true;
            } else if (result < value) {
                left++;
            } else right--;
        }
        return false;
    }


    private static boolean extracted(int[] array, int findNumber) {

        for (int i = 0; i < array.length; i++) {
            int foundNumber = findNumber - array[i];
            if (foundNumber <= 0) {
                continue;
            }

            for (int j = i + 1; j < array.length; j++) {
                if (foundNumber == array[j]) {
                    return true;
                }
            }
        }

        /*
         * Есть массив из целых положительных чисел.
         * Написать функцию, которая определяет можно ли заданное число представить суммой чисел из массив (каждое число можно
         * исользовать один раз):
         * пример:
         * Массив: array[1, 2, 9]
         * число Number - 10 - можно предсатвить суммой (1+9)
         * число 5 нельзя

         */
        return false;
    }
}
