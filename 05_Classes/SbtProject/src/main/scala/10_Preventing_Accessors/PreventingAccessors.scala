package r10_preventing_accessor_mutator

import com.alvinalexander.simpletest.SimpleTest.*

// p. 163
package t1 {
    class Animal:
        private var _numLegs = 2
        def numLegs = _numLegs                // getter
        def numLegs_=(numLegs: Int): Unit =   // setter
            _numLegs = numLegs

        // note that we can access the `_numLegs` field of // another Animal instance (`that`)
        def iHaveMoreLegs(that: Animal): Boolean =
            this._numLegs > that._numLegs


    @main def testPrivateModifier =
        val a = Animal()
        True(a.numLegs == 2)   // getter test

        a.numLegs = 4
        True(a.numLegs == 4)   // setter test

        // the default number of legs is 2, so this is true
        val b = Animal()
        True(a.iHaveMoreLegs(b))
}


// pp. 163-164
package t2 {
    class Animal:
        protected var _numLegs = 2
        def numLegs = _numLegs                // getter
        def numLegs_=(numLegs: Int): Unit =   // setter
            _numLegs = numLegs

        // note that we can access the `_numLegs` field of // another Animal instance (`that`)
        def iHaveMoreLegs(that: Animal): Boolean =
            this._numLegs > that._numLegs

    class Dog extends Animal:
        _numLegs = 4

    @main def testProtectedModifier =
        val a = Dog()
        True(a.numLegs == 4)

        a.numLegs = 3
        True(a.numLegs == 3)

        // the default number of legs is 4, so this is true
        val b = Dog()
        True(b.iHaveMoreLegs(a))
        
        // this won’t compile (variable _numLegs in class Animal cannot be accessed...):
        // a._numLegs
}






