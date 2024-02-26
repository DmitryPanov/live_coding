package coding.streams.live.stream_17_7.refactor;

import java.util.Objects;

public class RefactoringTest {
    private static final String FIRST_DO_SOME ="do some usual";
    private static final String SECOND_DO_SOME ="do some usual1";
    private static final String THIRD_DO_SOME ="do some usual2";
    private static final String FOUR_DO_SOME ="do some usual3";

    public static void main(String[] args) {
        RefactoringTest refactoringTest = new RefactoringTest();
        refactoringTest.someMethode();
        refactoringTest.someElseMethod();

    }

    public void changeSomeMethodByCondition(String condition){
        if (Objects.equals(condition, "some")){
            someMethode();
        } else {
            someElseMethod();
        }
    }

    private void someMethode() {
        doSomethingUsually(FIRST_DO_SOME, SECOND_DO_SOME);
        RefCreator.printOperativeRef();
        doSomethingUsually(THIRD_DO_SOME, FOUR_DO_SOME);
    }

    public static void refactorMethod(Printable printable) {
        System.out.println("do some usual");
        System.out.println("do some usual1");
        printable.print();
        System.out.println("do some usual2");
        System.out.println("do some usual3");
    }

    private void someElseMethod() {
        doSomethingUsually("Diiff", SECOND_DO_SOME);
        RefCreator.printHistoricalRef();
        doSomethingUsually("Diif12233", FOUR_DO_SOME);
    }

    private void doSomethingUsually(String do_some_usual, String do_some_usual1) {
        System.out.println(do_some_usual);
        System.out.println(do_some_usual1);
    }

    static class RefCreator {
        static void printOperativeRef() {
            System.out.println("operative ref");
        }

        static void printHistoricalRef() {
            System.out.println("historical ref");
        }
    }
}