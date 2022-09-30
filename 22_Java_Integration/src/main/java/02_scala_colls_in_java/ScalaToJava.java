package r02_collections;

import scala.jdk.javaapi.CollectionConverters;


// p. 652
class ScalaToJava1 {

    public static void main(String[] args) {

        ScalaClass sc = new ScalaClass();

        // access the `strings` field as `sc.strings()`
        scala.collection.immutable.List<String> xs = sc.strings();

        // create a Java List<String>
        java.util.List<String> listOfStrings = CollectionConverters.asJava(xs);
        listOfStrings.forEach(System.out::println);

        // short form
        // java.util.List<String> listOfStrings2 = CollectionConverters.asJava(
        //     (new ScalaClass()).strings()
        // );

    }
}


// p. 653
class ScalaToJava2 {

    public static void main(String[] args) {

        ScalaClass2 sc = new ScalaClass2();

        // one approach
        java.util.List<Object> listInt1 = CollectionConverters.asJava(sc.ints());
        listInt1.forEach(System.out::println);

        // this also works
        java.util.List listInt2 = CollectionConverters.asJava(sc.ints());
        listInt2.forEach(System.out::println);

        java.util.List<Integer> listIntegers =
            CollectionConverters.asJava(sc.jIntegers());
        listIntegers.forEach(System.out::println);

        // listOfStrings.forEach(System.out::println);

    }
}








