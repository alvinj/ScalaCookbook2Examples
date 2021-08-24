package r01_scope


// p. 236
package private1 {
    class Cat:
        private def isFriendlyCat = true    
        def sampleMethod(other: Cat) = 
            if other.isFriendlyCat then
                println("Can access other.isFriendlyCat")
                // ...
            end if
        end sampleMethod
    end Cat
}


// p. 236
package private2 {
    class Animal:
        private def heartBeat() = println("Animal heart is beating")

    // class Dog extends Animal:
    //     heartBeat()   // ERROR: Not found: heartBeat
}


// pp. 236-237
package protected1 {
    class Cat:
        protected def isFriendlyCat = true
        def catFoo(otherCat: Cat) =
            if otherCat.isFriendlyCat then   // this compiles
                println("Can access 'otherCat.isFriendlyCat'")
                // ...
            end if

    @main def CatTests =
        val c1 = Cat()
        val c2 = Cat()
        c1.catFoo(c2)         // this works

        // this code can’t access this method:
        // c1.isFriendlyCat   // does not compile
}


// p. 237
package protected2 {
    class Animal:
        protected def heartBeat() = println("Animal heart is beating")

    class Dog extends Animal:
        heartBeat()   // this 
}



// pp. 237-238
package package1 {
    package com.devdaily.coolapp.model:
        class Foo:
            // this is in “package scope”
            private[model] def privateModelMethod = ???   // can be accessed by
                                                          // classes in
                                                          // com.devdaily.coolapp.model
            private def privateMethod = ???
            protected def protectedMethod = ???

        class Bar:
            val f = Foo()
            f.privateModelMethod   // compiles
            // f.privateMethod     // won’t compile
            // f.protectedMethod   // won’t compile
}


// p. 238
package package2 {
    package com.devdaily.coolapp.model:
        class Foo:
            // available under com.devdaily.coolapp.model
            private[model] def doUnderModel = ???

            // available under com.devdaily.coolapp
            private[coolapp] def doUnderCoolapp = ???

            // available under com.devdaily
            private[devdaily] def doUnderAcme = ???

    import com.devdaily.coolapp.model.Foo

    package com.devdaily.coolapp.view:
        class Bar:
            val f = Foo()
            // f.doUnderModel  // won’t compile
            f.doUnderCoolapp
            f.doUnderAcme

    package com.devdaily.common:
        class Bar:
            val f = Foo()
            // f.doUnderModel     // won’t compile
            // f.doUnderCoolapp   // won’t compile
            f.doUnderAcme
}


// p. 239
package public1 {
    package com.devdaily.coolapp.model:
        class Foo:
            def doPublic = ???

    package some.other.scope:
        class Bar:
            val f = com.devdaily.coolapp.model.Foo()
            f.doPublic
}



