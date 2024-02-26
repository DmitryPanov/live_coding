package coding.string_task;

public class App {
    public static void main(String[] args) {
//        findElementString();
//        replaceAllElement();
//        replaceSomeElements();



    }

    private static void replaceSomeElements() {
    /*
    * Input: command = "G()(al)"
    Output: "Goal"
    Explanation: The Goal Parser interprets the command as follows:
    G -> G
    () -> o
    (al) -> al
    The final concatenated result is "Goal".*/
        String str = "G()(al)";
        System.out.println("interpret() = " + interpret(str));
        String command = "G()()()()(al)";
//        Output: "Gooooal"
        String command1 = "(al)G(al)()()G";
//        Output: "alGalooG"
        System.out.println("interpret(command) = " + interpret(command));
        System.out.println("interpret(command1) = " + interpret(command1));

        System.out.println("command = " + command.replace("()","o").replace("(al)","al"));
    }

    public static String interpret(String command) {
//        Map<String,String> map = new HashMap<>();
//        map.put("()","o");
//        map.put("(al)","al");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                sb.append("o");
                i++;
                continue;
            } else if (command.charAt(i) == '(' && command.charAt(i + 1) != ')') {
                sb.append(command.charAt(i + 1)).append(command.charAt(i + 2));
                i = i + 3;
                continue;
            }

            sb.append(command.charAt(i));
        }
        return sb.toString();
    }

    private static void findElementString() {
        String jewels = "aA";
        String stones = "aAAbbabbAAA";
//        Output: 3
        System.out.println("numJewelsInStones(stones,) = " + numJewelsInStones(jewels, stones));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int answer = 0;
        for (int i = 0; i < stones.length(); i++) {
            Character charElem = stones.charAt(i);
            if (jewels.contains(charElem.toString())) {
                answer++;
            }
        }
        return answer;
    }

    private static void replaceAllElement() {
        String address1 = "1.1.1.1";
//        String output: "1[.]1[.]1[.]1"
        String address2 = "255.100.50.0";
//        Output: "255[.]100[.]50[.]0"
        System.out.println("address1 = " + defangIPaddr(address1));
        System.out.println("address2 = " + defangIPaddr(address2));
    }

    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
