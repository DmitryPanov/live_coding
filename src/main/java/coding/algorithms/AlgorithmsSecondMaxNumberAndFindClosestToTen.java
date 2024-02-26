package coding.algorithms;

public class AlgorithmsSecondMaxNumberAndFindClosestToTen {
    public static void main(String[] args) {
//        System.out.println(preMax(new int[]{10, 10, 1, 2}));
        System.out.println("findClosestToTen(new int[]{8,9,5,12,17}) = " + findClosestToTen(new int[]{8,9,5,12,17}));
    }

    /**
     * Найти второе по величине число массива
     */
    public static int preMax(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                secondMax = max;
                max = numbers[i];
            } else if (max != numbers[i]) {
                if (secondMax < numbers[i]) {
                    secondMax = numbers[i];
                }
            }
        }
        return secondMax;
    }

    /**
     * Написать метод, который должен вернуть ближайшее к 10 число из входного массива чисел.
     * Если найдены несколько чисел равно удалённые от 10 - вернуть максимальное. К примеру:
     * если есть 9 и 11, то вернуть 11.
     */
    public static int findClosestToTen(int[] array) {
        int value = 10;
        int length = Integer.MAX_VALUE;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int dif = Math.abs(array[i] - value);
            if (dif < length) {
                length = dif;
                answer = array[i];
            }
            if (dif == length) {
                if (answer < array[i]) {
                    answer = array[i];
                }
            }
        }
        return answer;
    }
}
