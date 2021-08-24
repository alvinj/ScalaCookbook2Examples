package r05_scala_traits_in_java;

// p. 659
class JMath implements SAddTrait, SMultiplyTrait {
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class JMathTest {
    public static void main(String[] args) {
        JMath jm = new JMath();
        System.out.println(jm.sum(3, 4));        // 7
        System.out.println(jm.multiply(3, 4));   // 12
    }
}
