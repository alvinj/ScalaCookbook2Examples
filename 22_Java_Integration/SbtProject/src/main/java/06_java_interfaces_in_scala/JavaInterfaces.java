package r06_java_interfaces_in_scala;

// p. 660
interface Animal {
    void speak();
}

interface Wagging {
    void wag();
}

interface Running {
    // an implemented method
    default void run() {
        System.out.println("I’m running");
    }
}


// Discussion
interface Mathy {
    static int add(int a, int b) {
        return a + b;
    }
}



