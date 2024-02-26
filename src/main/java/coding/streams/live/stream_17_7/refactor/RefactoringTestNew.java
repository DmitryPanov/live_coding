package coding.streams.live.stream_17_7.refactor;
public class RefactoringTestNew {

    public static void main(String[] args) {

        /*RefactoringTest refactoringTest = new RefactoringTest();
        refactoringTest.someMethode();
        refactoringTest.someElseMethod();*/

        refactorMethod(() -> RefCreator.printHistoricalRef());
        refactorMethod(() -> RefCreator.printOperativeRef());

    }

    public static void refactorMethod(Printable printable) {
        System.out.println("do some usual");
        System.out.println("do some usual1");
        printable.print();
        System.out.println("do some usual2");
        System.out.println("do some usual3");
    }

    public void someMethode() {
        System.out.println("do some usual");
        System.out.println("do some usual1");
        RefCreator.printHistoricalRef();
        System.out.println("do some usual2");
        System.out.println("do some usual3");
    }

    public void someElseMethod() {
        System.out.println("do some usual");
        System.out.println("do some usual1");
        RefCreator.printHistoricalRef();
        System.out.println("do some usual2");
        System.out.println("do some usual3");
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

interface Printable {
    void print();
}