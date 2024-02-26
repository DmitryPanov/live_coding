package coding.algorithms;

import java.util.Stack;

public class AlgorithmsPalindromeAndGetPath {
    public static void main(String[] args) {
//        System.out.println("isPalindrome(454) = " + isPalindrome(454));
//        System.out.println("isPalindrome(455) = " + isPalindrome(455));
//        System.out.println(getPath("/var/lib/././../test/../check/result")); // /var/check/result
//        System.out.println(getPath("/var/./././test/anotherExample")); // /var/test/anotherExample
//        System.out.println(getPath("/var/check/../../oneMoreExample")); // /oneMoreExample
        System.out.println(getPathStack("/var/lib/././../test/../check/result")); // /var/check/result
        System.out.println(getPathStack("/var/./././test/anotherExample")); // /var/test/anotherExample
        System.out.println(getPathStack("/var/check/../../oneMoreExample")); // /oneMoreExample


    }

    public static String getPath(String path) {
        String[] arr = path.split("/");
        StringBuilder sb = new StringBuilder();
        int skip = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i].equals(".")) {
                continue;
            } else if (skip == 0 && (!arr[i].equals(".") && !arr[i].equals(".."))) {
                sb.insert(0, "/" + arr[i]);
            } else if (arr[i].equals("..")) {
                skip++;
            } else if (skip != 0) {
                skip--;
            }

        }

        return sb.toString();
    }

    public static String getPathStack(String path) {
        String[] arr = path.split("/");
        Stack stack = new Stack();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals(".")) {
                continue;
            } else if (arr[i].equals("..")) {
                stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }
        StringBuilder answer = new StringBuilder();
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            answer.insert(0, "/" + stack.pop());
        }

        return answer.toString();
    }

    public static boolean isPalindrome(int x) {
        String first = "" + x;
        StringBuilder sb = new StringBuilder(first);
        StringBuilder reverse = sb.reverse();
        return first.equals(reverse.toString());
    }
}
