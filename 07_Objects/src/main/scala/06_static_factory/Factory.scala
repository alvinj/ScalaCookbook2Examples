package r06_static_factory

import com.alvinalexander.simpletest.SimpleTest.*

// p. 226
@main def staticFactoryTest =
    import animals.*
    val cat = Animal("cat")
    val dog = Animal("dog")
    cat.speak()
    dog.speak()

