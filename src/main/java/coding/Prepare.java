package coding;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Prepare {
    public static void main(String[] args) {

        System.out.println(isValidBrackets2("(){}[]"));
        System.out.println(isValidBrackets("(){}[]"));
    }
    public static boolean isValidBrackets2 (String input){
        if(input.length() % 2 != 0){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(map.containsValue(c)){
                stack.push(c);
            } else if(map.containsKey(c)){
                if(stack.isEmpty()){
                    return false;
                } else if (stack.pop() != map.get(c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static boolean isValidString(String input) {
        Map<Character, Character> mapChar = new HashMap<>();
        mapChar.put('(', ')');
        mapChar.put('{', '}');
        mapChar.put('[', ']');
        if (input.length() % 2 != 0) {
            return false;
        }
        int middle = input.length() / 2;

        String first = input.substring(0, middle);
        String second = input.substring(middle);

        for (int i = 0; i < middle; i++) {
            if (second.charAt(i) != mapChar.get(first.charAt(middle - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidBrackets(String input) {

        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {

            if (brackets.containsValue(c)) {
                // одна из открывающих скобок
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                // одна из закрывающих скобок
                Character character = brackets.get(c);
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.pop() != character){
                    return false;
                }
            }
        }
// в конце стек должен быть пустым
        return stack.isEmpty();
    }
}
