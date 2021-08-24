package r08_varargs;

public class JVarargs {

    // pp. 662-663
    public static void main(String[] args) {
        VarargsPrinter.printAll("Hello", "world");
    }

    // p. 663
    public static void jPrintAll(String... args) {
        for (String s: args) {
            System.out.println(s);
        }
    }
}

