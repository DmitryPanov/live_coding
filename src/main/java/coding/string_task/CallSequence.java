package coding.string_task;

public class CallSequence {

    public static void main(String[] args) {
//        new CallSequence().new B();
    }

    class A {
        String str = "str";

        A() {
            printLength();
        }

         void printLength() {
            System.out.println("Parent Class: " +  str.length());
        }

    }

    class B extends A {
        String str = "str";

        void printLength() {
            System.out.println(str.length());
        }
    }

}