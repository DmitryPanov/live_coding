package coding.livecode28_07;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        CalculateBruttoImpl.init();
        CalculateBrutto calculateBrutto = new CalculateBruttoImpl();
        BigDecimal bigDecimal = calculateBrutto.calculateBrutto(200, "DE");
        System.out.println(bigDecimal);
        String word1 = "abcd";
        String word2 = "pq";

        String s = returnWord(word1, word2);
        System.out.println("s = " + s);

    }

    public static String returnWord(String word1, String world2) {
        StringBuilder sb = new StringBuilder();
        int first = 0;
        int second = 0;

        while (first != word1.length()  || second != world2.length() ) {
            if (first < word1.length()) {
                sb.append(word1.charAt(first));
                first++;
            }
            if (second < world2.length()) {
                sb.append(world2.charAt(second));
                second++;
            }
        }
        return sb.toString();
    }
}
